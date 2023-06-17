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
        example2();
    }


    public static void example1() throws InterruptedException {
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

    static boolean show = false;
    static int snapshot = 0;
    public static void example2() throws InterruptedException {
        int i = 0;

        while (true) {
            i++;
            Thread one = new Thread(() -> {
                a = 1;
                show = true;
            });

            Thread two = new Thread(() -> {
                if (show) {
                    snapshot = a;
                }
                //System.out.println(String.format("show = %b, a = %d, snapshot = %d", show, a, snapshot));

            });

            one.start();
            two.start();

            one.join();
            two.join();

            if(snapshot == 0){
                System.out.println("第" + i + "次 : Indicate Reordered: snapshot = " + snapshot);
                break;
            }else {
                a = 0;
                show = false;
                snapshot = -1;
            }
        }
    }
}
