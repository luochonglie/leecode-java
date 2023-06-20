package top.chonglie.multi.thread.guarded.object;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

@Slf4j
class CacheLinePaddingDemoTest {

    @Test
    void cacheLinePadding() throws InterruptedException {
        CacheLinePaddingDemo.CacheLinePadding[] cacheLinePadding = new CacheLinePaddingDemo.CacheLinePadding[]{
                new CacheLinePaddingDemo.CacheLinePadding(), new CacheLinePaddingDemo.CacheLinePadding()
        };

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                cacheLinePadding[0].number = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                cacheLinePadding[1].number = i;
            }
        });

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        stopWatch.stop();

        log.info("cache line padding cost {} ms", stopWatch.getTime());
    }

    @Test
    void noCacheLinePadding() throws InterruptedException {


        CacheLinePaddingDemo.NoCacheLinePadding[] noCacheLinePadding = new CacheLinePaddingDemo.NoCacheLinePadding[]{
                new CacheLinePaddingDemo.NoCacheLinePadding(), new CacheLinePaddingDemo.NoCacheLinePadding()
        };

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                noCacheLinePadding[0].number = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                noCacheLinePadding[1].number = i;
            }
        });

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        stopWatch.stop();

        log.info("no cache line padding cost {} ms", stopWatch.getTime());
    }

}

