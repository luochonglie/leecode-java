package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonotoneIncreasingDigitsTest {

    MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();

    @Test
    public void monotoneIncreasingDigits() {

        Assertions.assertEquals(123, solution.monotoneIncreasingDigits(123));

        Assertions.assertEquals(9, solution.monotoneIncreasingDigits(10));

        Assertions.assertEquals(8999, solution.monotoneIncreasingDigits(9998));

        Assertions.assertEquals(999, solution.monotoneIncreasingDigits(1101));

        Assertions.assertEquals(899, solution.monotoneIncreasingDigits(987));
    }
}