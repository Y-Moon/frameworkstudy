package com.demo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

public class SocketChannelReadHandle implements CompletionHandler<Integer,StringBuffer> {

    private AsynchronousSocketChannel asynchronousSocketChannel;
    private ByteBuffer byteBuffer;

    public SocketChannelReadHandle(AsynchronousSocketChannel socketChannel,ByteBuffer byteBuffer){
        this.asynchronousSocketChannel=socketChannel;
        this.byteBuffer=byteBuffer;
    }
    @Override
    public void completed(Integer result, StringBuffer historyContext) {
        if(result==-1){
            try{
                this.asynchronousSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("reader");
        this.byteBuffer.flip();
        byte[] contexts=new byte[1024];
        this.byteBuffer.get(contexts,0,result);
        this.byteBuffer.clear();
        String nowContent =new String(contexts,0,result, StandardCharsets.UTF_8);
        historyContext.append(nowContent);
        System.out.println("传输结果为："+historyContext);
        if(historyContext.indexOf("over")==-1){
            return;
        }
        System.out.println("出道完整信息");
        historyContext=new StringBuffer();
        this.asynchronousSocketChannel.read(this.byteBuffer,historyContext,this);
    }

    @Override
    public void failed(Throwable exc, StringBuffer attachment) {
        System.out.println("客户端异常关闭，服务端关闭tcp通道");
        try{
            this.asynchronousSocketChannel.close();
        } catch (IOException e) {
            System.out.println("关闭出错");
            e.printStackTrace();
        }
    }
}
