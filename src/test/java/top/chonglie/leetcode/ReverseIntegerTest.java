package top.chonglie.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * ReverseInteger Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/27/2022</pre>
 */
class ReverseIntegerTest {

    ReverseInteger solution = new ReverseInteger();

    /**
     * Method: reverse(int x)
     */
    @ParameterizedTest
    @CsvSource({
            "123, 321"
            , "12300, 321"
            , "-12, -21"
            , "-10, -1"
            , "2147483647, 0"
            , "-2147483412, -2143847412"
    })
    void testReverse(int parameter, int expected) {
        Assertions.assertEquals(expected, solution.reverse(parameter));
    }
} 
