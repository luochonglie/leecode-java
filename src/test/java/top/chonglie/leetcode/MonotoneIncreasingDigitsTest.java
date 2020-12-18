package top.chonglie.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.chonglie.test.CheckData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class MonotoneIncreasingDigitsTest {

    MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();

    @Test
    public void monotoneIncreasingDigits() {
        String message = "Input: %s, Expected: %s, Actual: %s.";
        List<CheckData<Integer,Integer>> dataList = new ArrayList<>();
        dataList.add(new CheckData(123, 123));
        dataList.add(new CheckData(10, 9));
        dataList.add(new CheckData(9998, 8999));
        dataList.add(new CheckData(1101, 999));

        dataList.forEach(data ->
                Assert.assertEquals(
                        String.format(message, data.input, data.expected, solution.monotoneIncreasingDigits(data.input))
                        , data.expected.intValue()
                        , solution.monotoneIncreasingDigits(data.input)
                )
        );
    }


}