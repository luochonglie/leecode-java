package top.chonglie.leetcode;

public class CharacterReplacement {

    /**
     * 424. 替换后的最长重复字符
     * <p>
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     * <p>
     * 注意：字符串长度 和 k 不会超过 104。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * <p>
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *
     * @param s 字符串
     * @param k 替换次数
     * @return 最长重复字符
     */
    public int characterReplacement(String s, int k) {
        // 取得字符串长度（能提速1ms）
        int sLength = s.length();
        // 将字符串转成字符数组，然后操作字符数组（能提速2ms）
        char[] sArray = s.toCharArray();
        // 记录窗口内字符的重复个数的字典
        int[] map = new int[26];
        // 偏移量
        int offset = 'A';
        // 最大长度
        int maxSizeOfDuplicateChar = 0;
        // 左边界
        int left = 0;
        // 右边界
        int right = 0;
        while (right < sLength) {
            // 1.计算当前字符在当前窗口内的重复个数
            // 2.记录最长重复字符个数
            maxSizeOfDuplicateChar = Math.max(maxSizeOfDuplicateChar, ++map[sArray[right] - offset]);

            // 3.如果当前窗口长度 > (比最长重复字符串长度 + k)，则需要缩小窗口（即左指针往右移一格）
            if (right - left + 1 > maxSizeOfDuplicateChar + k) {
                // 左指针的字符个数 - 1
                // 右移左指针
                map[s.charAt(left++) - offset]--;
            }

            //右指针右移
            right++;

        }

        //返回当前窗口长度
        return right - left;
    }

    public int characterReplacementV1(String s, int k) {
        // 记录窗口内此字符的个数
        int[] map = new int[26];
        // 偏移量
        int offset = 'A';
        // 最大长度
        int maxDuplicateChars = 0;
        // 左边界
        int left = 0;
        // 右边界
        int right = 0;
        while (right < s.length()) {
            // 1.计算当前字符在当前窗口内的重复个数
            // 2.记录最长重复字符个数
            maxDuplicateChars = Math.max(maxDuplicateChars, ++map[s.charAt(right) - offset]);

            // 3.如果当前窗口长度 > (比最长重复字符串长度 + k)，则需要缩小窗口（即左指针往右移一格）
            if (right - left + 1 > maxDuplicateChars + k) {
                // 左指针的字符个数 - 1
                // 右移左指针
                map[s.charAt(left++) - offset]--;
            }

            //右指针右移
            right++;

        }

        //返回当前窗口长度
        return right - left;
    }


}
