package top.chonglie.layout;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ObjectLayoutTest {

    @Test
    @Order(1)
    void test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ObjectLayout objectLayout = new ObjectLayout();
        objectLayout.setA(1);
        objectLayout.setB(1);
        log.info(ClassLayout.parseInstance(objectLayout).toPrintable());

        stopWatch.stop();
        log.info("cost {} ms", stopWatch.getTime());
    }

    private final long loopTimes = 1_000_000_000_0L;

    @Test
    @Order(2)
    void test2() {
        StopWatch stopWatch = new StopWatch();

        ObjectLayout objectLayout = new ObjectLayout();
        objectLayout.setA(1);
        stopWatch.start();

        for (long i = 0; i < loopTimes; i++) {
            if (1 == objectLayout.getA()) {
                objectLayout.setA(1);
            }
        }
        stopWatch.stop();

        log.info("getA() cost {} ms", stopWatch.getTime());
    }

    @Test
    @Order(3)
    void test3() {
        StopWatch stopWatch = new StopWatch();

        ObjectLayout objectLayout = new ObjectLayout();
        objectLayout.setB(1);
        stopWatch.start();

        for (long i = 0; i < loopTimes; i++) {
            if (1 == objectLayout.getB()) {
                objectLayout.setB(1);
            }
        }
        stopWatch.stop();

        log.info("getB() cost {} ms", stopWatch.getTime());
    }

}

