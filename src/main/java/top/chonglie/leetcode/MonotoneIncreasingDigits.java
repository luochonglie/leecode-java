package top.chonglie.leetcode;

import java.util.Arrays;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int result = 0;
        int digitMax = 10;
        int digit = 1;

        while (N > 0){
            int t = N % 10;
            if(t <= digitMax){
                result += t * digit;
                digitMax = t;
            }else {
                result = t * digit - 1;
                digitMax = t - 1;
            }

            N /= 10;
            digit *= 10;
        }


        return result;

    }
}
