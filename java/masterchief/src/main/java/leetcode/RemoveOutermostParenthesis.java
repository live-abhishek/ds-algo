package leetcode;

import java.util.Stack;

public class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String S) {
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stk.push(c);
            } else {
                stk.pop();
            }
            temp.append(c);
            if (stk.isEmpty()) {
                temp.deleteCharAt(0);
                temp.deleteCharAt(temp.length() - 1);
                ans.append(temp);
                temp = new StringBuilder();
            }
        }
        return ans.toString();
    }
}
