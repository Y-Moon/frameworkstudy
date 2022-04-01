package com.nettyTest.lazydemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class LazyTest {
    public LazyTest(){
        System.out.println("创建lazy对象");
    }
    public String getResult(){
        return "result";
    }
}
