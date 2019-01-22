package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int ansLength = num1.length() + num2.length();
        int[] ans = new int[ansLength];
        for(int i = 0; i < ans.length; i++) ans[i] = 0;

        int placeStartPos = ansLength - 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int changePos = placeStartPos;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int prod = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                ans[changePos] += prod;
                int toSave = ans[changePos] % 10;
                int toCarry = ans[changePos] / 10;
                ans[changePos] = toSave;
                ans[changePos - 1] += toCarry;
                changePos--;
            }
            placeStartPos--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans) {
            if(i != 0) sb.append(i);
            if(i == 0 && sb.length() > 0) sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("73", "64"));
        System.out.println(m.multiply("2", "3"));
        System.out.println(m.multiply("11", "10"));
    }
}
