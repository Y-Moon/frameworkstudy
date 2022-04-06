package com.demo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerSocketChannelHandle  implements CompletionHandler<AsynchronousSocketChannel,Void> {
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    public ServerSocketChannelHandle(AsynchronousServerSocketChannel asynchronousServerSocketChannel){
        this.asynchronousServerSocketChannel=asynchronousServerSocketChannel;
    }
    @Override
    public void completed(AsynchronousSocketChannel result, Void attachment) {
        this.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer allocate = ByteBuffer.allocate(50);
        result.read(allocate,new StringBuffer(),new SocketChannelReadHandle(result,allocate));
    }

    @Override
    public void failed(Throwable exc, Void attachment) {
        System.out.println("ServerSocketChannelHandle处理失败");
    }
}
