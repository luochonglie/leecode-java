package top.chonglie.leetcode;


/**
 * 有效的括号
 */
public class ValidParentheses {

    /**
     * <p><a href="https://leetcode-cn.com/problems/valid-parentheses/">20. 有效的括号</a></p>
     *
     * @param s 括号字符串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        // Valid Parentheses
        // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        if (s.length() % 2 != 0) {
            return false;
        }
        // 用数组模拟栈
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是左括号，则入栈
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                // 如果是右括号，则出栈
                if (top < 0) {
                    return false;
                }
                char left = stack[top--];
                if (c == ')' && left != '(') {
                    return false;
                }
                if (c == ']' && left != '[') {
                    return false;
                }
                if (c == '}' && left != '{') {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
