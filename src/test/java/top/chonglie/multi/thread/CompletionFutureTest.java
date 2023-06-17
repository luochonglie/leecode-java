package top.chonglie.multi.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @program: leetcode-java
 * @description: CompletionFutureTest
 * @author: c0l0121
 * @modified: c0l0121
 * @create: 2021-08-12 15:46
 */
class CompletionFutureTest {

    @Test
    void testExecutorService() {
        // 1. 创建线程池
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(new NamedSerialSupplier(new String[]{"aa", "bb"}, 2));
        // 2. 创建线程
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new NamedSerialSupplier(new String[]{"cc", "dd"}, 2));
        // 3. 合并线程
        CompletableFuture<String> f3 = f1.thenCombine(f2, (r1, r2) -> {
            return String.format("%s, %s", r1, r2);
        });
        // 4. 打印结果
        System.out.println(f3.join());
        Assertions.assertTrue(true);
    }
}
