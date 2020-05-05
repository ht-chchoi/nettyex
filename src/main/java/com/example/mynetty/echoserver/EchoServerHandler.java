package com.example.mynetty.echoserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg)
        throws Exception {
        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());

        System.out.println("수신한 문자열 ["+readMessage+"]");

        ctx.write(msg);
    }

    @Override public void channelReadComplete(final ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
