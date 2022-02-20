package top.chonglie.leetcode;

import java.util.*;

public class LengthOfLongestSubstring {

    /**
     * 移动窗口 + 数组字符位置 + 只移动指针不删除重复数字
     * @param s 待处理的字符串
     * @return 最大不重复字串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 用数组记录字符曾经出现的位置
        int[] charPositions = new int[128];
        int POSITION_INIT = -1;
        // 将每个元素初始化为不可能出现的位置值（负数）
        Arrays.fill(charPositions, POSITION_INIT);

        // 最长长度
        int maxLength = 0;
        // 子字符串窗口左指针，初始位置为0
        int left = 0;
        // 子字符串窗口右指针，初始位置为0
        int right = 0;
        // 当前的字符
        char currentChar;
        // 相同字符上一次出现的位置
        int sameCharPrePosition;
        while (right < s.length()) {
            // 获取当前字符
            currentChar = s.charAt(right);
            // 获取相同字符的前一次的位置
            sameCharPrePosition = charPositions[currentChar];
            // 如果上一次出现的位置 >= 左指针，表示当前字符在当前的子字符串窗口中重复
            // 如果字符没有出现过，值为 -1 ，在当前子字符串中不重复
            // 如果字符出现过，但位置小于左指针，在当前子字符串中不重复
            if (sameCharPrePosition >= left) {
                left = sameCharPrePosition + 1;
            } else {
                // 记录最长子串的长度
                maxLength = Math.max(maxLength, right - left + 1);
                // 更新字符出现位置
                charPositions[currentChar] = right++;
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringMovingWindowMap(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;

        Integer charPosition;
        while (right < s.length()) {
            charPosition = dic.get(s.charAt(right));
            if (charPosition != null && charPosition >= left) {
                left = charPosition + 1;
            } else {
                max = Math.max(max, right - left + 1);
                dic.put(s.charAt(right), right++);
            }
        }

        return max;
    }

    public int lengthOfLongestSubstringMovingWindow(String s) {
        Set<Character> dic = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (dic.contains(s.charAt(right))) {
                dic.remove(s.charAt(left++));
            } else {
                max = Math.max(max, right - left + 1);
                dic.add(s.charAt(right++));
            }
        }

        return max;
    }


    /**
     * 暴力解题
     * 从第一个字符开始，计算最长的不重复子字符串，记录长度
     * 然后，从第二个字符开始，计算最长的不重复字符串，记录最大长度
     * 持续此操作，直至最后一个字符
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param s 待判断最长不重复子串的字符串
     * @return 最长不重复子串的长度
     */
    public int lengthOfLongestSubstringCirculation(String s) {
        Set<Character> dic = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            dic.clear();
            for (int j = i; j < s.length(); j++) {
                if (dic.contains(s.charAt(j))) {
                    break;
                } else {
                    dic.add(s.charAt(j));
                }
            }
            max = Math.max(max, dic.size());
        }

        return max;
    }
}
