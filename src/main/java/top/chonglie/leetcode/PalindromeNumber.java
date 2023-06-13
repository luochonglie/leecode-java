package top.chonglie.leetcode;

/**
 * 回文数<br/>
 * 例如：0~9，11，22，121
 */
public class PalindromeNumber {

    /**
     * 判断输入的数字是否为回文数字
     *
     * @param x 待判断数字
     * @return true：是回文数，false：不是回文数
     */
    public boolean isPalindrome(int x) {
        // 处理不会为回文数字的情况
        // 负数不是回文数字：-123 ！= 321-
        // 以0结尾，且不是0的数字不是回文数字： 10 != 1
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int revent = 0;
        while (revent < x) {
            revent = revent * 10 + x % 10;
            x /= 10;
        }

        return revent == x || revent / 10 == x;
    }


    /**
     * 回文数
     * 转换成整数数组，然后判断对应位置的数字是否一样
     * 耗时：5ms
     * 击败；74%
     *
     * @param x 待检测数字
     * @return 是否为回文数字
     */
    public boolean isPalindrome_v1(int x) {
        if (x < 0) {
            return false;
        }
        int[] input = new int[32];
        int length = 0;
        // 将数字转换成数组
        while (x != 0) {
            input[length++] = x % 10;
            x /= 10;
        }
        // 如果只有一位，返回是回文串
        if (length <= 1) {
            return true;
        }
        for (int i = 0; i < length / 2; i++) {
            if (input[i] != input[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
