package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                Integer num2 = stk.pop();
                Integer num1 = stk.pop();
                int res = evaluate(num1, num2, tokens[i]);
                stk.push(res);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.peek();
    }

    private int evaluate(int num1, int num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return num1; // as per question this will never happen
        }
    }
}
