package top.chonglie.leetcode;

/**
 * 单调递增的数字
 * <p>给定一个非负整数<b>N</b>，找出小于或等于<b>N</b>的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。</p>
 * <p>（当且仅当每个相邻位数上的数字<b>x</b>和<b>y</b>满足<b>x</b> <= <b>y</b>时，我们称这个整数是单调递增的。）</p>
 *
 * <p>
 * 示例 1:
 * <blockquote>
 * <pre>
 * 输入: N = 10
 * 输出: 9
 * </pre>
 * </blockquote>
 * </p>
 *
 * <p>
 * 示例 2:
 * <blockquote>
 * <pre>
 * 输入: N = 1234
 * 输出: 1234
 * </pre>
 * </blockquote>
 * </p>
 *
 * <p>说明: N 是在 [0, 10^9] 范围内的一个整数。</p>
 *
 * @see <a href="https://leetcode-cn.com/problems/monotone-increasing-digits/">单调递增的数字</a>
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int result = 0;
        int multiple = 1;

        while (N > 0) {
            int digit = N % 10;

            N /= 10;

            int high = N % 10;

            if (high > digit) {
                result = multiple * 10 - 1;
                N -= 1;
            } else {
                result += digit * multiple;
            }

            multiple *= 10;
        }

        return result;

    }
}
