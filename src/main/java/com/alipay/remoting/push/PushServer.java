package com.alipay.remoting.push;

import com.alipay.remoting.AbstractRemotingServer;
import com.alipay.remoting.CommandCode;
import com.alipay.remoting.RemotingProcessor;
import com.alipay.remoting.rpc.protocol.UserProcessor;

import java.util.concurrent.ExecutorService;

/**
 * @Author : xuaoping
 */
public class PushServer extends AbstractRemotingServer {

    public PushServer(int port) {
        super(port);
    }

    public PushServer(String ip, int port) {
        super(ip, port);
    }

    @Override
    protected void doInit() {

    }

    @Override
    protected boolean doStart() throws InterruptedException {
        return false;
    }

    @Override
    protected boolean doStop() {
        return false;
    }

    @Override
    public void registerProcessor(byte protocolCode, CommandCode commandCode, RemotingProcessor<?> processor) {

    }

    @Override
    public void registerDefaultExecutor(byte protocolCode, ExecutorService executor) {

    }

    @Override
    public void registerUserProcessor(UserProcessor<?> processor) {

    }

}
