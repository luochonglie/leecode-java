package top.chonglie.multi.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: leetcode-java
 * @description:
 * @author: c0l0121
 * @modified:
 * @create: 2021-10-27 22:34
 */
public class SleepTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 2; i++) {
            System.out.println("before");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("after");
        }

    }
}
