package com.nettyTest.component;

import org.springframework.stereotype.Component;

@Component
public class BeanDemoImp2 implements BeanDemo{
    public BeanDemoImp2(){
        System.out.println("初始化BeanDemoImp2");
    }

    @Override
    public String sayHello() {
        return "BeanDemoImp2 say hello";
    }
}
