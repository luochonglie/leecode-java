package top.chonglie.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dic = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(dic.contains(s.charAt(right))){
                dic.remove(s.charAt(left++));
            }else {
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
