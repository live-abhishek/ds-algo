package codingInterview.slidingWindow;

import java.util.HashMap;
import java.util.Map;

// TODO
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {

        Map<Character, Integer> patternMap = getPatternMap(pattern);
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int l = 0, r = 0; r < str.length(); r++) {
            char c = str.charAt(r);
            if(patternMap.containsKey(c)) {
                addCharacter(windowMap, c);
                while (windowMap.get(c) > patternMap.get(c)) {
                    removeCharacter(windowMap, str.charAt(l));
                    l++;
                }
                if (r - l + 1 == pattern.length()) {
                    return true;
                }
            } else {
                windowMap = new HashMap<>();
                l = r + 1;
            }
        }
        return false;
    }

    private static void addCharacter(Map<Character, Integer> map, char c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void removeCharacter(Map<Character, Integer> map, char c) {
        int count = map.getOrDefault(c, 0);
        if (count > 1) {
            map.put(c, count - 1);
        } else {
            map.remove(c);
        }
    }

    private static Map<Character, Integer> getPatternMap(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println(StringPermutation.findPermutation("odicf", "dc"));
        System.out.println(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(StringPermutation.findPermutation("aaacb", "abc"));
    }
}
