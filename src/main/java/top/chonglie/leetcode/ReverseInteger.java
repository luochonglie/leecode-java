package top.chonglie.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int digit;
        int reversed = 0;

        while (x != 0) {
            digit = x % 10;
            reversed = reversed * 10 + digit;
            if (Integer.MIN_VALUE / 10 > reversed || reversed > Integer.MAX_VALUE / 10) {
                return 0;
            }
            x = x / 10;
        }

        return reversed;
    }


    public int reverseV1(int x) {
        StringBuilder original = new StringBuilder(String.valueOf(x));
        if (x < 0) {
            original.deleteCharAt(0);
        }

        String reversed = original.reverse().toString();

        long longResult;

        if (x < 0) {
            longResult = -Long.parseLong(reversed);
        } else {
            longResult = Long.parseLong(reversed);
        }

        if (longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) longResult;
        }
    }
}
