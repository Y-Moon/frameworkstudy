package demo;

import com.nettyTest.util.PrintUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

public class QueenDemo {
    @Test
    public void demo1() throws InterruptedException {
        BlockingQueue<String> blockingQueue=new LinkedBlockingDeque<>(1);
        blockingQueue.put("ss");
        PrintUtil.print(blockingQueue.take());
        blockingQueue.put("ss1");
        PrintUtil.print("结束");
    }
    @Test
    public void demo2() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new LinkedBlockingDeque<>(10);
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            PrintUtil.print("生产者开始消费");
            IntStream.range(0, 100)
                    .forEach(i -> {
                        try {
                            blockingQueue.put(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            PrintUtil.print("生产者消费结束");
            return "生产结束";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            PrintUtil.print("消费者开始消费");
            IntStream.range(0, 90)
                    .forEach(i -> {
                        try {
                            blockingQueue.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            PrintUtil.print("消费者消费结束");
            return "消费完成";
        }), (a, b) -> a + b);
        PrintUtil.print("结果："+future.join());
        PrintUtil.print("结束");
    }
}
