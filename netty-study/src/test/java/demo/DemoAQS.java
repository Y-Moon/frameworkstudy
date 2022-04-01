package demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class DemoAQS extends AbstractQueuedSynchronizer {
    @Test
    public void demoAQS() {
        final ReentrantLock lock = new ReentrantLock();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("线程" + i) {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        lock.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName() + "开始执行！");
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "执行结束！");
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + "被打断");
                    } finally {
                        lock.unlock();
                    }
                }
            };
            threadList.add(thread);
            thread.start();
        }
        threadList.get(3).interrupt();
        LockSupport.park();
    }
    @Test
    public void testForEach(){
        IntStream.range(1,1000).forEach(value->{
            System.out.println(Thread.currentThread().getName());
            IntStream.range(1,1000).forEach(value1->{
                System.out.println(Thread.currentThread().getName());
            });
        });
    }
    @Test
    public void parkTest() throws InterruptedException {
        Thread thread1=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//                LockSupport.park();
        });
        thread1.start();
        Thread.sleep(500);
        System.out.println(thread1.getState());
    }
    @Test
    public void testUnlock() throws InterruptedException {
        ReentrantLock lock= new ReentrantLock(true);
        lock.lock();
        System.out.println("123");
        lock.unlock();
    }

    public static void main(String[] args) {
        int i=10,j,k;
        j=k=i;
        System.out.println(j);
        System.out.println(k);
        System.out.println(i);
    }
}
