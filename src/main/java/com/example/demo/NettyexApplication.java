package com.example.demo;

import com.example.mynetty.discardserver.DiscardServer;
import com.example.mynetty.echoserver.EchoServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyexApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(NettyexApplication.class, args);
        DiscardServer discardServer = new DiscardServer();
//        discardServer.initNettyServer();

        EchoServer echoServer = new EchoServer();
        echoServer.initNettyServer();
    }

}
