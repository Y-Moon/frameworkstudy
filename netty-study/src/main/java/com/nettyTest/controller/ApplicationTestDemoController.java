package com.nettyTest.controller;

import com.nettyTest.component.BeanDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationTestDemoController {
    @Autowired
    private BeanDemo beanDemo;

    @GetMapping("testDemo")
    public String applicationDemo(){
        return beanDemo.sayHello();
    }
}
