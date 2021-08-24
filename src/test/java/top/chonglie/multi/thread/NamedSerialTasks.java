package top.chonglie.multi.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 串行任务
 *
 * @program: leetcode-java
 * @description: 任务
 * @author: c0l0121
 * @modified:
 * @create: 2021-08-12 13:57
 */
public class NamedSerialTasks implements Callable<String> {
    private static final Random RANDOM = new Random();

    private String[] taskNames;

    private int difficulty;

    public NamedSerialTasks(String[] taskNames, int difficulty) {
        this.taskNames = taskNames;
        this.difficulty = difficulty;
    }

    @Override
    public String call() throws Exception {
        try {
            for (String jobName : taskNames) {
                long sleepSeconds = difficulty + RANDOM.nextInt(5);
                System.out.println(String.format("%s - Begin  - [%s] need [%d] seconds.", Thread.currentThread().getName(), jobName, sleepSeconds));
                Thread.sleep(sleepSeconds * 1000);
                System.out.println(String.format("%s - End    - [%s].", Thread.currentThread().getName(), jobName));
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("%s - Canceled.", Thread.currentThread().getName()));
        }

        String result = String.format("%s has finished [%s] ", Thread.currentThread().getName(), Arrays.toString(taskNames));
        return result;
    }
}
