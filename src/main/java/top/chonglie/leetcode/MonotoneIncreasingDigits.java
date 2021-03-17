package top.chonglie.leetcode;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int result = 0;
        int max = 10;
        int multiple = 1;

        while (N > 0){
            int digit = N % 10;

            N /= 10;

            int high = N % 10;

            if(high > digit){
                result = multiple * 10 - 1;
                N -= 1;
            }else {
                result += digit * multiple ;
            }

            multiple *= 10;
        }

        return result;

    }
}
