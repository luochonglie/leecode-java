package top.chonglie.lock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lock {

    public static void main(String[] args){

        Lock lock = new Lock();
        lock.getLock();
    }

    public void getLock() {

        Set<Long> whiteList = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            whiteList.add((long) i);
        }

        List<Long> upcList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            upcList.add((long) i * 10);
        }

        // 1. upcList 与 whiteList 交集
        List<Long> intersection = new ArrayList<>();
        intersection.addAll(upcList);
        intersection.retainAll(whiteList);
        System.out.println("intersection: " + intersection);

        // 2. upcList 与 whiteList 差集
        List<Long> difference = new ArrayList<>();
        difference.addAll(upcList);
        difference.removeAll(whiteList);
        System.out.println("difference: " + difference);

        // 3. whiteList 与 upcList 差集
        List<Long> difference2 = new ArrayList<>();
        difference2.addAll(whiteList);
        difference2.removeAll(upcList);
        System.out.println("difference2: " + difference2);

        // 4. whiteList 与 upcList 交集
        List<Long> intersection2 = new ArrayList<>();
        intersection2.addAll(whiteList);
        intersection2.retainAll(upcList);
        System.out.println("intersection2: " + intersection2);


    }
}
