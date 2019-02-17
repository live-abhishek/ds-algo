package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Character> orderMap = orderMap(order);
        for (int i = 0; i < words.length; i++) {
            words[i] = convertCharacter(words[i], orderMap);
        }
        return isSorted(words);
    }

    private boolean isSorted(String[] words) {
        String[] newStrings = Arrays.copyOf(words, words.length);
        Arrays.sort(newStrings);
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals(newStrings[i])) return false;
        }
        return true;
    }

    private String convertCharacter(String string, Map<Character, Character> orderMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char convertedChar = orderMap.get(string.charAt(i));
            sb.append(convertedChar);
        }
        return sb.toString();
    }

    private Map<Character, Character> orderMap(String order) {
        HashMap<Character, Character> orderMap = new HashMap<Character, Character>();
        for (char i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), (char)('a' + i));
        }
        return orderMap;
    }
}
