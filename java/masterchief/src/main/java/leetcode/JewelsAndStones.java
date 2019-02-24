package leetcode;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character>  jewelTypes = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewelTypes.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (jewelTypes.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
