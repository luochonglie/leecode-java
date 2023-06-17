package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * TwoSum Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/27/2022</pre>
 */
class TwoSumTest {

    TwoSum solution = new TwoSum();

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})
                , Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2})
                , Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
                , Arguments.of(new int[]{2, 5, 5, 11}, 10, new int[]{1, 2})
        );
    }

    /**
     * Method: twoSum(int[] nums, int target)
     */
    @ParameterizedTest
    @MethodSource("arguments")
    void twoSum(int[] nums, int target, int[] expect) {
        Assertions.assertArrayEquals(expect, solution.twoSum(nums, target));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void twoSumV1(int[] nums, int target, int[] expect) {
        Assertions.assertArrayEquals(expect, solution.twoSumV1(nums,target));
    }

}
