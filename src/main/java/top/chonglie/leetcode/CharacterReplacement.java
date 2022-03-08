package top.chonglie.leetcode;

public class CharacterReplacement {

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
