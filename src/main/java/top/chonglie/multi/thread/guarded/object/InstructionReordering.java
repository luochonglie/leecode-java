package top.chonglie.multi.thread.guarded.object;

import static java.lang.Thread.sleep;

/**
 * 指令重排序的例子
 */
public class InstructionReordering {


    public static void main(String[] args) throws InterruptedException {
        example1();
        //example2();
    }

    // 定义变量
    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void example1() throws InterruptedException {
        System.out.println("指令重排序样例【1】 ==== 开始运行");
        // 记录循环次数
        int loopTimes = 0;
        while (true) {

            // 创建线程一，操作a，x
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            // 创建线程二，操作b，y
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            // 启动线程
            one.start();
            two.start();

            // 等待线程结束
            one.join();
            two.join();

            // 输出结果
            String result = String.format("第%d次(%d,%d)", loopTimes, x, y);

            // 判断是否出现了（0,0）的情况
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
            // 循环次数加一
            loopTimes++;

            // 重置变量
            x = 0;
            y = 0;
            a = 0;
            b = 0;
        }
        System.out.println("指令重排序样例【1】 ==== 运行结束");

    }

    static boolean show = false;
    static int snapshot = -1;
    static int varChangeBeforeShow = 0;

    public static void example2() throws InterruptedException {
        System.out.println("指令重排序样例【2】 ==== 开始运行");

        int loopTimes = 0;

        while (true) {
            Thread one = new Thread(() -> {
                // show 可能会被重排序到 varChangeBeforeShow 之前
                varChangeBeforeShow = 1;
                show = true;
            }, "one");

            Thread two = new Thread(() -> {
                // show 为 true 时，varChangeBeforeShow 可能为 0
                if (show) {
                    snapshot = varChangeBeforeShow;
                }
            }, "two");

            // 启动线程
            one.start();
            two.start();

            // 等待线程结束
            one.join();
            two.join();

            // 输出结果
            if (show && snapshot == 0) {
                System.err.println(String.format("第%d次, show = %b，snapshot = %d", loopTimes, show, snapshot));
                break;
            }


            // 重置变量
            varChangeBeforeShow = 0;
            show = false;
            snapshot = -1;

            // 循环次数加一
            loopTimes++;
        }

        System.out.println("指令重排序样例【2】 ==== 运行结束");
    }
}
