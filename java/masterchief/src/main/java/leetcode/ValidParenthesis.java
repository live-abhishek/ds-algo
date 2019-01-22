package leetcode;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else {
                // because no left side character was inserted ever
                if (stk.empty()) return false;
                Character other = stk.peek();
                if ((other == '(' && ch == ')') || (other == '[' && ch == ']') || (other == '{' && ch == '}')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}
