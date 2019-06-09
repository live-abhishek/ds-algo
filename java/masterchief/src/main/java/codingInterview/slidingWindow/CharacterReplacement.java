package codingInterview.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        // map of character their frequency in the sliding window
        Map<Character, Integer> map = new HashMap<>();
        // holds the count of repetition of character which is
        // repeated most number of times in the sliding window
        int currentMaxRepeatitionCount = 0;
        int maxLen = 0;
        for(int l = 0, r = 0; r < str.length(); r++){
            char c = str.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            currentMaxRepeatitionCount = Integer.max(currentMaxRepeatitionCount, map.get(c));
            int currentLen = r - l + 1;
            if (currentLen - currentMaxRepeatitionCount > k) {
                char leftChar = str.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
            maxLen = Integer.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
