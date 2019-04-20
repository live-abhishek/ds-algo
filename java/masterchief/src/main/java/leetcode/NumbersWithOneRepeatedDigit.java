package leetcode;

import java.util.HashSet;
import java.util.Set;

// TODO
public class NumbersWithOneRepeatedDigit {
    public int numDupDigitsAtMostN(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (hasRepeated(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasRepeated(int n) {
        Set<Character> set = new HashSet<>();
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return true;
            } else {
                set.add(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NumbersWithOneRepeatedDigit n = new NumbersWithOneRepeatedDigit();
    }
}
