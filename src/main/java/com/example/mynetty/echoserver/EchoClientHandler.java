package com.example.mynetty.echoserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        String sendMessage = "Hello Netty!";

        ByteBuf messageBuffer = Unpooled.buffer();
        messageBuffer.writeBytes(sendMessage.getBytes());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("전송한 문자열 [");
        stringBuilder.append(sendMessage);
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());

        ctx.writeAndFlush(messageBuffer);
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg)
        throws Exception {
        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());

        System.out.println("수신한 문자열 ["+readMessage+"]");
    }

    @Override public void channelReadComplete(final ChannelHandlerContext ctx) throws Exception {
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
