package demo;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void print(String content){
        System.out.println(Thread.currentThread().getName()+"--"+content);
    }
    @Test
    public void testDemo1(){
        print("开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead2";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
                try{
                    print("内线程开始");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print("休息结束");
                return "thead3";
            }),(a,b)->{
            return "合并后："+a+"--"+b;
        });
        print("主线程");
        print(future.join());
        print("结束");
    }
    @Test
    public void testDemo2(){
        print("开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead2";
        }).thenComposeAsync(r->CompletableFuture.supplyAsync(()->{
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead3";
        }));
        print("主线程");
        print(future.join());
        print("结束");
    }
    @Test
    public void testDemo3(){
        print("开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead2";
        }).thenApply(r->{
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead3";
        });
        print("主线程");
        print(future.join());
        print("结束");
    }
    @Test
    public void testDemo4(){
        print("开始");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead2";
        }).thenApply(r->{
            try{
                print("内线程开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i=1/0;
            print("休息结束");
            return "thead3";
        }).exceptionally(e->{
            e.printStackTrace();
            return "异常发生";
        });
        print("主线程");
        print(future.join());
        print("结束");
    }
    @Test
    public void testDemo5(){
        print("开始");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try{
                print("内线程开始");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead2";
        }).thenApply(r->{
            try{
                print("内线程开始");
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead3";
        }).applyToEitherAsync(CompletableFuture.supplyAsync(()->{
            try{
                print("内线程开始");
                Thread.sleep(910);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("休息结束");
            return "thead4";
        }),r->{
            return r;
        });
        print("主线程");
        print(future.join());
        print("结束");
    }
}
