package top.chonglie.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TwoSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/27/2022</pre>
 */
public class TwoSumTest {

    TwoSum solution = new TwoSum();

    /**
     * Method: twoSum(int[] nums, int target)
     */
    @Test
    public void testTwoSum_1() throws Exception {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] expects = new int[]{0, 1};

        Assert.assertArrayEquals(expects, solution.twoSum(nums, target));
    }

    @Test
    public void testTwoSum_2() throws Exception {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] expects = new int[]{1, 2};

        Assert.assertArrayEquals(expects, solution.twoSum(nums, target));
    }

    @Test
    public void testTwoSum_3() throws Exception {
        int[] nums = new int[]{3, 3};
        int target = 6;

        int[] expects = new int[]{0, 1};

        Assert.assertArrayEquals(expects, solution.twoSum(nums, target));
    }

    @Test
    public void testTwoSum_4() throws Exception {
        int[] nums = new int[]{2,5,5,11};
        int target = 10;

        int[] expects = new int[]{1, 2};

        Assert.assertArrayEquals(expects, solution.twoSum(nums, target));
    }

}
