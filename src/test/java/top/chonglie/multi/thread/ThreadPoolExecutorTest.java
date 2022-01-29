package top.chonglie.multi.thread;



import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.swing.SwingUtilities2.submit;

/**
 * <p>线程池执行器的测试类</p>
 * <p>通过两个子线程分别执行可并行的任务，主线程等待子线程返回结果后执行后续工作。
 * <blockquote>
 * <pre>
 * T1 -> Wash pot -> Boil water      -|
 *                                    | -> T3 -> Make tea
 * T2 -> Wash teapot -> Wash teacup  -|
 *
 * </pre>
 * </blockquote>
 * </p>
 *
 * @program: leetcode-java
 * @description: 线程池测试
 * @author: c0l0121
 * @modified:
 * @create: 2021-08-06 17:31
 */
public class ThreadPoolExecutorTest {

    /**
     * @throws Exception
     */
    @Test
    public void testExecutorService() throws Exception {
        // Create executor
        ExecutorService executor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>(100), new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName(String.format("Worker[%02d]", counter.addAndGet(1)));
                return t;
            }
        });

        List<Future<String>> futureList = new ArrayList<>();

        // Submit task
        futureList.add(executor.submit(new NamedSerialTasks(new String[]{"Wash pot", "Boil water"}, 5)));
        futureList.add(executor.submit(new NamedSerialTasks(new String[]{"Wash teapot", "Wash teacup"}, 1)));

        // Wait for pre tasks finished, then get result from sub thread.
        Future<String> f;
        for (int i = 0; i < futureList.size(); i++) {
            f = futureList.get(i);
            System.out.println(String.format("%s - %s", Thread.currentThread().getName(), f.get()));
        }

        // Execute follow-up tasks
        f = executor.submit(new NamedSerialTasks(new String[]{"Make tea"}, 1));
        System.out.println(String.format("%s - %s", Thread.currentThread().getName(), f.get()));
    }


}
