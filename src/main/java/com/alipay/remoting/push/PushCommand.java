package com.alipay.remoting.push;

import com.alipay.remoting.CommandCode;
import com.alipay.remoting.InvokeContext;
import com.alipay.remoting.ProtocolCode;
import com.alipay.remoting.RemotingCommand;
import com.alipay.remoting.config.ConfigManager;
import com.alipay.remoting.config.switches.ProtocolSwitch;
import com.alipay.remoting.exception.DeserializationException;
import com.alipay.remoting.exception.SerializationException;
import com.alipay.remoting.rpc.protocol.RpcProtocol;

/**
 * @Author : xuaoping
 */
public abstract class PushCommand implements RemotingCommand {


    private static final long serialVersionUID = 4788307387094704755L;

    /**
     * Code which stands for the command.
     */
    private CommandCode cmdCode;

    /* command version */
    private byte version = 0x1;

    private byte type;
    /**
     * Serializer, see the Configs.SERIALIZER_DEFAULT for the default serializer.
     * Notice: this can not be changed after initialized at runtime.
     */
    private byte serializer = ConfigManager.serializer;
    /**
     * protocol switches
     */
    private ProtocolSwitch protocolSwitch = new ProtocolSwitch();

    private int id;


    private int contentLength = 0;
    /**
     * The bytes format of the content of the command.
     */
    private byte[] content;
    /**
     * invoke context of each command.
     */
    private InvokeContext invokeContext;

    public PushCommand() {
    }

    public PushCommand(byte type) {
        this();
        this.type = type;
    }

    public PushCommand(CommandCode cmdCode) {
        this();
        this.cmdCode = cmdCode;
    }

    public PushCommand(byte type, CommandCode cmdCode) {
        this(cmdCode);
        this.type = type;
    }

    public PushCommand(byte version, byte type, CommandCode cmdCode) {
        this(type, cmdCode);
        this.version = version;
    }

    @Override
    public ProtocolCode getProtocolCode() {
        //todo
        return ProtocolCode.fromBytes(RpcProtocol.PROTOCOL_CODE);
    }

    @Override
    public CommandCode getCmdCode() {
        return this.cmdCode;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public InvokeContext getInvokeContext() {
        return this.invokeContext;
    }

    @Override
    public byte getSerializer() {
        return 0;
    }

    @Override
    public ProtocolSwitch getProtocolSwitch() {
        return this.protocolSwitch;
    }

    @Override
    public void serialize() throws SerializationException {

    }

    @Override
    public void deserialize() throws DeserializationException {
        this.deserializeContent(invokeContext);
    }

}
