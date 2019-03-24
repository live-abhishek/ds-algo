package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinaryStringWithSubStringRepresentingOneToN {
    public boolean queryString(String S, int N) {
        Set<Integer> set = new HashSet<>();
        for (int s = 1; s <= S.length(); s++) {
            int num = 0;
            for (int i = 0; i < s; i++) {
                num = num << 1;
                num = num | getBit(S.charAt(i));
            }
            set.add(num);
            for (int i = s; i < S.length() - s + 1; i++) {
                // turn off n-1 th bit
                num = num & ~(1<<(s-1));
                // left shift
                num = num << 1;
                // add last bit
                num = num | getBit(S.charAt(i+s-1));
                set.add(num);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private int getBit(Character c) {
        return c == '1' ? 1 : 0;
    }

    public static void main(String[] args) {
        BinaryStringWithSubStringRepresentingOneToN b = new BinaryStringWithSubStringRepresentingOneToN();
        String S = "0110";
        int N = 3;
        boolean ans = b.queryString(S, N);
        System.out.println(ans);
    }

}
