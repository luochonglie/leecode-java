package top.chonglie.multi.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: leetcode-java
 * @description: a
 * @author: c0l0121
 * @modified:
 * @create: 2021-08-12 15:46
 */
public class CompletionFutureTest {

    @Test
    public void testExecutorService() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(new NamedSerialSupplier(new String[]{"aa","bb"}, 2));
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new NamedSerialSupplier(new String[]{"cc","dd"}, 2));
        CompletableFuture<String> f3 = f1.thenCombine(f2, (r1, r2) -> {
            return String.format("%s, %s", r1,r2);
        });




        System.out.println(f3.join());
    }
}
