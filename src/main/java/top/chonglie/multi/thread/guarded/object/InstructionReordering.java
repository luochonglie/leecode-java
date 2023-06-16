package top.chonglie.multi.thread.guarded.object;

/**
 * 指令重排序的例子
 */
public class InstructionReordering {
    // 定义变量
    static int x = 0, y = 0;
    // 定位变量
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });


            one.start();
            two.start();
            one.join();
            two.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
            x = 0;
            y = 0;
            a = 0;
            b = 0;
        }
    }
}
