package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringLength {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, leftIndex = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                leftIndex = Integer.max(map.get(ch), leftIndex);
            }
            maxLen = Integer.max(i - leftIndex, maxLen);
            map.put(ch, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringLength longestSubstringLength = new LongestSubstringLength();
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("dvdf"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("abcdbe"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("abba"));
        System.out.println(longestSubstringLength.lengthOfLongestSubstring("zwnigfunjwz"));
    }
}
