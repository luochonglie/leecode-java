package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    /**
     * Method: twoSum(int[] nums, int target)
     */
    @ParameterizedTest
    @CsvSource({
            "'[2, 7, 11, 15]', 9,  '[0, 1]'"
            , "'[3, 2, 4]', 6, '[1, 2]'"
            , "'[3, 3]', 6 , '[0, 1]'"
            , "'[2, 5, 5, 11]', 10, '[1, 2]'"
    })
    void testTwoSum(String nums, int target, String expect) throws Exception {
        Assertions.assertArrayEquals(string2IntArray(expect), solution.twoSum(string2IntArray(nums), target));
    }

    private int[] string2IntArray(String input) {
        return Stream.of(input.substring(1, input.length() - 1).split(",\\s+")).mapToInt(Integer::parseInt).toArray();
    }


}
