package top.chonglie.multi.thread.guarded.object;

/**
 * 显示类的字节码
 */
public class ShowClassByteCode {
    static class T{
        int m = 8;
    }
    public static void main(String[] args) {
        // New an object
        T o = new T();
        // Print the class name
        System.out.println(o);
    }
}
