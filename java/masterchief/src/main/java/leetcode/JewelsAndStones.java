package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character>  jewelTypes = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewelTypes.add(J.charAt(i));
        }
        Map<Character, Integer> stoneCounts = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = stoneCounts.getOrDefault(c, 0);
            stoneCounts.put(c, count + 1);
        }
        stoneCounts.keySet().retainAll(jewelTypes);
        int ans = 0;
        for (int count : stoneCounts.values()) {
            ans += count;
        }
        return ans;
    }
}
