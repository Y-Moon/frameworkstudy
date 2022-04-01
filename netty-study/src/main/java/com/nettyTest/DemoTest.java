package com.nettyTest;

import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;

public class DemoTest {
    public static void main(String[] args) {
        EventExecutor executor=new DefaultEventExecutor();
        Promise promise=new DefaultPromise(executor);

        promise.addListener(future -> {
            System.out.println("测试监听1"+future.getNow());
        }).addListener(future -> {
            System.out.println("测试监听2"+future.getNow());
        });
        executor.submit(()->{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            promise.setSuccess(123);
//            promise.setFailure(new RuntimeException());
        });
        try {
            promise.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
