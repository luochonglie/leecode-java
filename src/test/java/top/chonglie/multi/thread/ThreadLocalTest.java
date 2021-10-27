package top.chonglie.multi.thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: leetcode-java
 * @description: 本地线程测试类
 * @author: c0l0121
 * @modified:
 * @create: 2021-08-24 15:58
 */
public class ThreadLocalTest {

    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(100);
    ExecutorService executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, workQueue);

    private static int THREAD_COUNT = 2;

    @Test
    public void testThreadId() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(THREAD_COUNT);

        for(int i = 0; i < THREAD_COUNT; i++){
            executor.submit(() -> {
                System.out.println(String.format("1. nextId = %d", ThreadId.get()));
                System.out.println(String.format("2. nextId = %d", ThreadId.get()));
                System.out.println(String.format("3. nextId = %d", ThreadId.get()));
                cdl.countDown();
            });
        }

        cdl.await();
    }
}

class ThreadId{
    private static final AtomicLong nextIdGen = new AtomicLong(0);
    static final ThreadLocal<Long> tl = ThreadLocal.withInitial(() -> nextIdGen.getAndIncrement());
    static Long get(){
        return tl.get();
    }
}
