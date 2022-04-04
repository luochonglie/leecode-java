package top.chonglie.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetupIntegerInHex {
    @ParameterizedTest
    @CsvSource({
            "07, 7"
            ,"010, 8"
            ,"012, 10"
            ,"00, 0"
            ,"-07, -7"
            ,"-010, -8"
    })
    /**
     * 给int赋值时，以0开头，为8进制数字
     */
    public void test8Hex(int input, int expected){
        Assertions.assertEquals(input, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0x11, 17"
            ,"0x10, 16"
            ,"0xa, 10"
            ,"0xf, 15"
            ,"0x0, 0"
            ,"-0xa, -10"
            ,"-0xf, -15"
            ,"-0x10, -16"
            ,"-0x11, -17"
    })
    /**
     * 给int赋值时，以0x开头，为16进制数字
     * @param input
     * @param expected
     */
    public void test16Hex(int input, int expected){
        Assertions.assertEquals(input, expected);
    }
}
