package com.nettyTest;

import com.nettyTest.component.BeanDemo;
import com.nettyTest.component.BeanDemoImp1;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NettyStart {
    public static void main(String[] args) {
        SpringApplication.run(NettyStart.class,args);
    }
}
