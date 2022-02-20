package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * LengthOfLongestSubstring Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/17/2022</pre>
 */
class LengthOfLongestSubstringTest {

    LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

    /**
     * Method: lengthOfLongestSubstring(String s)
     */
    @ParameterizedTest
    @CsvSource({
            "a, 1",
            "ab, 2",
            "aba, 2",
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwke, 3",
            "'',0",
            "' ', 1"
    })
    void testLengthOfLongestSubstring(String input, int expected) {
        Assertions.assertEquals(expected, solution.lengthOfLongestSubstring(input));
    }


} 
