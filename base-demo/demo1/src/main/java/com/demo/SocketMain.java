package com.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class SocketMain {
    public static final Object waitObject=new Object();
    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("0.0.0.0",90));
        serverSocketChannel.accept(null,new ServerSocketChannelHandle(serverSocketChannel));
        synchronized (waitObject){
            waitObject.wait();
        }
    }
}
