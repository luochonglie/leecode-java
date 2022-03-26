package top.chonglie.leetcode;

/**
 * 回文串整数
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        return false;
    }
}
