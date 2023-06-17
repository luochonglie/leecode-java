package top.chonglie.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromeNumberTest {
    PalindromeNumber palindromeNumber = new PalindromeNumber();

    @ParameterizedTest
    @CsvSource({
            "121, true",
            "-121, false",
            "10, false"
    })
    void testIsPalindrome(int input, boolean expected) {
        boolean actual = palindromeNumber.isPalindrome(input);
        Assertions.assertEquals(expected, actual);
    }
}