package top.chonglie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-java
 * @description: 两数之和
 * <a href="https://leetcode-cn.com/problems/two-sum/">两数之和</a>
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target
 * 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案
 * <p>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 缓存处理过的数值和其位置的对应关系
        Map<Integer, Integer> handled = new HashMap<>();
        // 放入第一个元素
        handled.put(nums[0], 0);

        // 从第二个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 如果目标值和当前值的差，在处理过的数据中，则命中
            if (handled.containsKey(target - nums[i])) {
                return new int[]{handled.get(target - nums[i]), i};
            }
            // 否则，将数值和位置的对应关系存储缓存
            handled.put(nums[i], i);
        }

        // 没有结果则返回空数组
        return new int[0];
    }

    public int[] twoSumV1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

}
