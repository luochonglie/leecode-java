package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ReverseInteger Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/27/2022</pre>
 */
public class ReverseIntegerTest {

    ReverseInteger solution = new ReverseInteger();

    /**
     * Method: reverse(int x)
     */
    @Test
    public void testReversePositive() {
        int param = 123;
        int expect = 321;

        Assertions.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReversePositiveEndWithZero() {
        int param = 12300;
        int expect = 321;

        Assertions.assertEquals(expect, solution.reverse(param));
    }


    @Test
    public void testReverseBiggerThanMaxInt() {
        int param = 2147483647;
        int expect = 0;

        Assertions.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReverseNegative() {
        int param = -12;
        int expect = -21;

        Assertions.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReverseNegativeEndWithZero() {
        int param = -10;
        int expect = -1;

        Assertions.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReverse_3() {
        int param = -2147483412;
        int expect = -2143847412;

        Assertions.assertEquals(expect, solution.reverse(param));
    }

} 
