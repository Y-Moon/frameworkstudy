package com.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("demo/test")
    public String getDemo(){
        return "demo2";
    }
}
