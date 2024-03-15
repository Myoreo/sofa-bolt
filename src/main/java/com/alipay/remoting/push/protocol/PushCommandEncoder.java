package com.alipay.remoting.push.protocol;

import com.alipay.remoting.CommandEncoder;
import com.alipay.remoting.push.PushCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.Serializable;

/**
 * @Author : xuaoping
 */
public class PushCommandEncoder implements CommandEncoder {

    @Override
    public void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) throws Exception {
        if (msg instanceof PushCommand) {
            PushCommand cmd = (PushCommand) msg;
            out.writeShort(cmd.getCmdCode().value());
        }
    }

}
