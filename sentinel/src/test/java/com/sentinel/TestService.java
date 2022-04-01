package com.sentinel;

import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.junit.Test;

public class TestService {
    @SentinelResource(value = "hello",blockHandler = "exceptionHandler",fallback = "helloFallback")
    public String hello(long s){
        return String.format("Hello at %d",s);
    }
    public String helloFallback(long s){
        return String.format("Helloooooo at %d",s);
    }
    public String exceptionHandler(long s, BlockException ex){
        ex.printStackTrace();;
        return String.format("Oops, error occurred at" ,s);
    }
    @SentinelResource(value = "test",blockHandler = "handleException",blockHandlerClass = {ExceptionUtil.class})
    public void test(){
        System.out.println("Test");
    }
}
