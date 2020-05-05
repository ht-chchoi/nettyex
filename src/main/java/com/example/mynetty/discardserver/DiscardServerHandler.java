package com.example.mynetty.discardserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardServerHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final Object msg)
        throws Exception {

    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause)
        throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
