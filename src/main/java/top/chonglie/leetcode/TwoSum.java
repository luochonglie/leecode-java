package top.chonglie.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> gap = new HashMap<>();
        gap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if(gap.containsKey(target - nums[i])){
                return new int[]{gap.get(target - nums[i]), i};
            }
            gap.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum_1(int[] nums, int target) {
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
