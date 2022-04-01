package com.nettyTest.config;

import com.nettyTest.component.BeanDemo;
import com.nettyTest.component.BeanDemoImp1;
import com.nettyTest.component.BeanDemoImp2;
import com.nettyTest.lazydemo.LazyTest;
import com.nettyTest.lazydemo.MainController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

@Configuration
public class WebConfig {
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @PostConstruct
    public void init(){
        beanFactory.registerResolvableDependency(BeanDemo.class,new BeanDemoImp2());
    }


    @Lazy
    @Bean
    public LazyTest lazyTest(){
        return new LazyTest();
    }
}
