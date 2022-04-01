package com.nettyTest.lazydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private LazyTest lazyTest;

    @GetMapping("lazyDemo")
    public String testLazy(){
        return lazyTest.getResult();
    }
}
