package codingInterview.slidingWindow;

import java.util.*;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> map = getPatternMap(pattern);
        int matched = 0;
        for (int l = 0, r = 0; r < str.length(); r++) {
            char c = str.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                resultIndices.add(l);
            }

            if (r >= pattern.length() - 1) {
                char leftChar = str.charAt(l);
                l++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }

    private static Map<Character, Integer> getPatternMap(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
