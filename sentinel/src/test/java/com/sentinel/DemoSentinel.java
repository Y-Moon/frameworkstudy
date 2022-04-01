package com.sentinel;

import com.alibaba.csp.sentinel.*;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class DemoSentinel {
    @Test
    public void testDemoSentinel1(){
        //传入热点参数时，不能用此方法，热点统计会失效
        try (Entry entry=SphU.entry("resource")){
            //业务逻辑
        } catch (BlockException e) {
            //降级限流操作
            e.printStackTrace();
        }
    }
    @Test
    public void testDemoSentinel2(){
        Entry entry=null;
        //热点参数
        Object[] paramA=new Object[0];
        try{
            entry=SphU.entry("resource", EntryType.IN,1,paramA);
        } catch (BlockException e) {
            //降级限流操作
            e.printStackTrace();
        }finally {
            //exit,需要携带热点参数
            if(entry!=null){
                entry.exit(1,paramA);
            }
        }
    }
    @Test
    public void testDemoSentinel3(){
        if(SphO.entry("resource")){
            try{
                //业务操作
            }finally {
                SphO.exit();
            }
        }else{
            //限流降级操作
        }
    }
    //注解限流
    @Test
    @SentinelResource(blockHandler = "blockHandlerUser")
    public void testDemoSentinel4(){

    }
    //返回参数要和限流方法一致
    public void blockHandlerUser(String id,BlockException ex){
        //限流降级操作
    }
    //异步调用
    @Test
    public void asyncHandle(){
        try{
            AsyncEntry resource = SphU.asyncEntry("resource");
            doAsync("1",result->{
                try{
                    //处理异步调用的结果
                }finally {
                    resource.exit();
                }
            });
        } catch (BlockException e) {
            e.printStackTrace();
            //限流降级操作
        }
    }
    public void doAsync(String id, Consumer<String> consumer){
        try{
            //等待3秒来模拟异步
            TimeUnit.SECONDS.sleep(3);
            String resp=id+"--";
            consumer.accept(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initFlowQpsRule(){

    }
}
