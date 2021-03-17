package top.chonglie.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonotoneIncreasingDigitsTest {

    MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();
    @Test
    public void monotoneIncreasingDigits() {
        Assert.assertEquals(123, solution.monotoneIncreasingDigits(123));

        Assert.assertEquals(9, solution.monotoneIncreasingDigits(10));

        Assert.assertEquals(8999, solution.monotoneIncreasingDigits(9998));

        Assert.assertEquals(999, solution.monotoneIncreasingDigits(1101));
    }
}