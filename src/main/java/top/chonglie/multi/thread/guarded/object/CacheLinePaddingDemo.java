package top.chonglie.multi.thread.guarded.object;

/**
 * 缓存行对齐的例子
 */
public class CacheLinePaddingDemo {
    private CacheLinePaddingDemo() {
    }

    static class CacheLinePadding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;

        public volatile long number = 0L;

        public volatile long p8, p9, p10, p11, p12, p13, p14;
    }

    static class NoCacheLinePadding {
        public volatile long number = 0L;
    }
}
