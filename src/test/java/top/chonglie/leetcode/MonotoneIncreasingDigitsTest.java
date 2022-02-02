package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MonotoneIncreasingDigitsTest {

    MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();

    @ParameterizedTest
    @CsvSource({
            "123, 123"
            , "10, 9"
            , "9998, 8999"
            , "1101, 999"
            , "987, 899"
    }
    )
    public void monotoneIncreasingDigits(int input, int expected) {
        Assertions.assertEquals(expected, solution.monotoneIncreasingDigits(input));
    }
}