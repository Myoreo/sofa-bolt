package com.alipay.remoting.push.protocol;

import com.alipay.remoting.*;


/**
 * Request command protocol for v1
 * 0     1     2           4           6           8          10           12          14         16
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |proto| type| cmdcode   |ver2 |   requestId           |codec|        timeout        |  classLen |
 * +-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
 * |headerLen  | contentLen            |                             ... ...                       |
 * +-----------+-----------+-----------+                                                                                               +
 * |               className + header  + content  bytes                                            |
 * +                                                                                               +
 * |                               ... ...                                                         |
 * +-----------------------------------------------------------------------------------------------+
 *
 * proto: code for protocol
 * type: request/response/request oneway
 * cmdcode: code for remoting command
 * ver2:version for remoting command
 * requestId: id of request
 * codec: code for codec
 * headerLen: length of header
 * contentLen: length of content
 *
 * Response command protocol for v1
 * 0     1     2     3     4           6           8          10           12          14         16
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |proto| type| cmdcode   |ver2 |   requestId           |codec|respstatus |  classLen |headerLen  |
 * +-----------+-----------+-----------+-----------+-----------+-----------+-----------+-----------+
 * | contentLen            |                  ... ...                                              |
 * +-----------------------+                                                                       +
 * |                         className + header  + content  bytes                                  |
 * +                                                                                               +
 * |                               ... ...                                                         |
 * +-----------------------------------------------------------------------------------------------+
 * respstatus: response status
 *
 * @author xuaoping
 *
 */
public class PushProtocol implements Protocol {

    public static final byte PROTOCOL_CODE       = (byte) 1;
    private static final int REQUEST_HEADER_LEN  = 22;
    private static final int RESPONSE_HEADER_LEN = 20;
    private CommandEncoder   encoder;
    private CommandDecoder   decoder;
    private HeartbeatTrigger heartbeatTrigger;
    private CommandHandler   commandHandler;
    private CommandFactory   commandFactory;

    public PushProtocol(){

    }

    @Override
    public CommandEncoder getEncoder() {
        return null;
    }

    @Override
    public CommandDecoder getDecoder() {
        return null;
    }

    @Override
    public HeartbeatTrigger getHeartbeatTrigger() {
        return null;
    }

    @Override
    public CommandHandler getCommandHandler() {
        return null;
    }

    @Override
    public CommandFactory getCommandFactory() {
        return null;
    }
}
