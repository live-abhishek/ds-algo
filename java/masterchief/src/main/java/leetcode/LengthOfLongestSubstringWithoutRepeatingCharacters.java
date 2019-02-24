package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Integer.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Integer.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
