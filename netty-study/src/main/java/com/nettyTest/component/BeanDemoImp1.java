package com.nettyTest.component;

import org.springframework.stereotype.Component;

@Component
public class BeanDemoImp1 implements BeanDemo{
    public BeanDemoImp1(){
        System.out.println("初始化BeanDemoImp1");
    }

    @Override
    public String sayHello() {
        return "BeanDemoImp1 say hello";
    }
}
