package codingInterview.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int maxLen = 0;
        // map of character their left most position in the sliding window
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < str.length(); r++) {
            char c = str.charAt(r);
            if (map.containsKey(c)) {
                l = map.get(c) + 1;
            }
            map.put(c, r);
            maxLen = Integer.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabcBBb"));
    }
}
