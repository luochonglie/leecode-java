package top.chonglie.multi.thread.guarded.object;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @program: leetcode-java
 * @description:
 * @author: c0l0121
 * @modified:
 * @create: 2021-10-27 23:08
 */
public class GuardedObject<T> {
    private T obj;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();
    private final int timeout = 1;

    T get(Predicate<T> p) {
        lock.lock();
        try {
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return obj;
    }

    void onChange(T obj){
        lock.lock();
        try{
            this.obj = obj;
            done.notifyAll();
        }finally {
            lock.unlock();
        }
    }
}
