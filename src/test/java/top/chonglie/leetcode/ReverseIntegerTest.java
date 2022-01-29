package top.chonglie.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
    public void testReverse_1() {
        int param = 123;
        int expect = 321;

        Assert.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReverse_2() {
        int param = 1534236469;
        int expect = 0;

        Assert.assertEquals(expect, solution.reverse(param));
    }

    @Test
    public void testReverse_3() {
        int param = -2147483412;
        int expect = -2143847412;

        Assert.assertEquals(expect, solution.reverse(param));
    }

} 
