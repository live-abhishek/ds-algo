package codingInterview.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int maxLen = 0;
        // map of character their frequency in the sliding window
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < str.length(); r++) {
            char c = str.charAt(r);
            // add this character to map
            increment(map, c);
            // while our map contains more than k distinct chars, remove left most char
            while (map.size() > k) {
                char leftChar = str.charAt(l);
                decrement(map, leftChar);
                l++;
            }
            // now we have <= k distinct characters. Recompute the length
            maxLen = Integer.max(maxLen, r - l + 1);

            // ================== // below was my 1st pass at the algorithm

            /*//
            if (map.containsKey(c)) { // character already present in map
                increment(map, c); // add that character to map
                maxLen = Integer.max(maxLen, r - l + 1); // recompute new length
            } else { // character not in map
                if (map.size() < k) { // but num of distinct char is smaller than k
                    increment(map, c); // just add that character to map
                    maxLen = Integer.max(maxLen, r - l + 1); // recompute new length
                } else { // but adding this char will violate constraint
                    // remove character from left until we are no more violating our constraint
                    while (map.size() > k - 1) { // while our map contains more than k - 1 distinct chars
                        char leftChar = str.charAt(l);
                        decrement(map, leftChar); // remove the left most character
                        l++; // move left pointer to right
                    }
                    // now we have exactly k - 1 unique characters. we can add this character
                    increment(map, c);
                }
            }*/
        }
        return maxLen;
    }

    private static void increment(Map<Character, Integer> map, Character character) {
        map.put(character, map.getOrDefault(character,0) + 1);
    }

    private static void decrement(Map<Character, Integer> map, Character character) {
        int count = map.get(character);
        if (count > 1) {
            map.put(character, count - 1);
        } else {
            map.remove(character);
        }
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
