package top.chonglie.leetcode;

/**
 * <p>
 * 738. 单调递增的数字
 * <p>
 *  给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。<br/>
 *  （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）<br/>
 * </p>
 * <p>
 *  示例1：
 *  <blockquote>
 *      <pre>
 *          <bold>输入:</bold> N = 10
 *          <bold>输出:</bold> 9
 *      </pre>
 *  </blockquote>
 *  示例2：
 *  <blockquote>
 *      <pre>
 *          <bold>输入:</bold> N = 1234
 *          <bold>输出:</bold> 1234
 *      </pre>
 *  </blockquote>
 * </p>
 * <p>
 * 来源：力扣（LeetCode）<br/>
 * 出处：<a href="https://leetcode-cn.com/problems/monotone-increasing-digits">738. 单调递增的数字</a>
 * </p>
 * </p>
 * @author c0l0121
 *
 */
public class MonotoneIncreasingDigits {

    /**
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     * @param   N
     *          正整数
     * @return
     *          正整数
     */
    public int monotoneIncreasingDigits(int N) {
        int result = 0;
        int multiple = 1;

        String a;

        while (N > 0){
            // 当前位
            int currentDigit = N % 10;
            // 待处理的数字前进一位
            N /= 10;
            // 高位
            int highDigit = N % 10;
            // 高位是否大于当前位
            if(highDigit > currentDigit){
                // 从高位借1
                N -= 1;
                // 低位全部设置为9
                result = multiple * 10 - 1;
            }else {
                // 将当前位设置到对应位置
                result += currentDigit * multiple ;
            }
            //进一位
            multiple *= 10;
        }

        return result;

    }
}
