package top.chonglie.leetcode;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        // 记录窗口内此字符的个数
        int[] map = new int[26];
        // 偏移量
        int offset = 'A';
        // 最大长度
        int maxDuplicateChars = 0;
        // 窗口的左右指针
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 1.计算当前字符在窗口内的个数
            map[s.charAt(right) - offset]++;
            // 2.记录最长重复字符个数
            maxDuplicateChars = Math.max(maxDuplicateChars, map[s.charAt(right) - offset]);

            // 2.如果当前窗口长度，比最长重复字符串 + k 大，需要缩小窗口，即左指针往右移一格
            if (right - left + 1 > maxDuplicateChars + k) {
                map[s.charAt(left++) - offset]--;
            }

            //右指针右移
            right++;

        }

        //返回当前窗口长度
        return right - left;
    }


}
