package top.chonglie.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidParenthesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @CsvSource({
            "(), true",
            "()[]{}, true",
            "(], false",
            "([)], false",
            "{[]}, true",
            "{[([({})])]}, true",
            "], false",
            "), false",
            "}, false",
            "([, false",
            "(}, false",
            "([), false",})
    @ParameterizedTest
    void testIsValid(String param, boolean expected) {
        boolean result = validParentheses.isValid(param);
        Assertions.assertEquals(expected, result);
    }
}
