package com.nettyTest.util;

public class PrintUtil {
    public static void print(String content){
        System.out.println(Thread.currentThread().getName()+"--"+content);
    }
}
