package com.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StarterDemo1 {
    public static void main(String[] args) {
        SpringApplication.run(StarterDemo1.class,args);
    }
}
