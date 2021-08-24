package top.chonglie.multi.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>分别在子线程执行相同的任务，任一有返回就用返回的结果，取消剩余线程任务。</p>
 * <pre>
 *     t1 -> getQuotes -> executing -|
 *     t2 -> getQuotes -> executing -| -> t1 -> cancel -> t2 -> cancel -> return result from t3
 *     t3 -> getQuotes -> return    -|
 * </pre>
 *
 * @program: leetcode-java
 * @description: 线程池测试
 * @author: c0l0121
 * @modified:
 * @create: 2021-08-06 17:31
 */
public class CompletionServiceTest {

    @Test
    public void testExecutorService() {

        // Create completion service
        CompletionService<String> cs = new ExecutorCompletionService<>(
                new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES
                        , new LinkedBlockingDeque<Runnable>(100)
                        , new ThreadFactory() {
                    private final AtomicInteger counter = new AtomicInteger();

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName(String.format("Worker[%02d]", counter.addAndGet(1)));
                        return t;
                    }
                }));

        // Create future list
        List<Future<String>> futureList = new ArrayList<>();

        // Add future to list
        futureList.add(cs.submit(new NamedSerialTasks(new String[]{"aa", "bb", "cc"}, 5)));
        futureList.add(cs.submit(new NamedSerialTasks(new String[]{"aa", "bb", "cc"}, 5)));
        futureList.add(cs.submit(new NamedSerialTasks(new String[]{"aa", "bb", "cc"}, 1)));

        String result = "";
        try {
            // Get first return
            result = cs.take().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Cancel all tasks
            for (Future<String> f : futureList) {
                f.cancel(true);
            }
        }

        //Use result
        System.out.println(String.format("%s - %s", Thread.currentThread().getName(), result));
    }

}
