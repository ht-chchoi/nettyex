package com.example.demo;

import com.example.mynetty.discardserver.DiscardServer;
import com.example.mynetty.echoserver.EchoClient;
import com.example.mynetty.echoserver.EchoServer;
import com.example.mynetty.telnetServer.TelnetServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyexApplication
{
    @Value("${server.telnet.port}")
    private int telnetPort;

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(NettyexApplication.class, args);

        TelnetServer telnetServer = new TelnetServer();
        telnetServer.startTelnetServer(8023);

//        DiscardServer discardServer = new DiscardServer();
//        discardServer.initNettyServer();

//        EchoServer echoServer = new EchoServer();
//        echoServer.initNettyServer();

//        EchoClient echoClient = new EchoClient();
//        echoClient.initNettyClient();
    }

}
