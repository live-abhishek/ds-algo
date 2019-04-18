package leetcode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(Character.toString(ch));
            } else {
                if (ch == '[') {
                    stk.push(Character.toString(ch));
                } else if (Character.isDigit(ch)) {
                    if (isNumericalString(stk.peek())) {
                        addCharacterToTopmostString(stk, ch);
                    } else {
                        stk.push(Character.toString(ch));
                    }
                } else if (ch == ']') {
                    String temp = stk.pop();
                    stk.pop(); // pop '['
                    int num = Integer.parseInt(stk.pop());
                    String replicateStr = replicateStr(temp, num);
                    if (!stk.isEmpty() && isAlphabeticString(stk.peek())) {
                        addStirngToTopmostString(stk, replicateStr);
                    } else {
                        stk.push(replicateStr);
                    }
                } else { // character is a letter
                    if (stk.isEmpty()) {
                        stk.push(Character.toString(ch));
                    } else if(stk.peek().equals("[")) {
                        stk.push(Character.toString(ch));
                    } else { // stack top is a string of alphabet
                        addCharacterToTopmostString(stk, ch);
                    }
                }
            }
        }
        return stk.empty() ? "" : stk.peek();
    }

    private void addStirngToTopmostString(Stack<String> stk, String str) {
        String pop = stk.pop();
        stk.push(pop + str);
    }

    private void addCharacterToTopmostString(Stack<String> stk, char ch) {
        String pop = stk.pop();
        String newString = pop + Character.toString(ch);
        stk.push(newString); // add this new character to the string
    }

    private boolean isNumericalString(String str) {
        char c = str.charAt(0);
        return Character.isDigit(c);
    }

    private boolean isAlphabeticString(String str){
        char c = str.charAt(0);
        if (Character.isDigit(c) || c == '[' || c == ']') {
            return false;
        }
        return true;
    }

    private String replicateStr(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
