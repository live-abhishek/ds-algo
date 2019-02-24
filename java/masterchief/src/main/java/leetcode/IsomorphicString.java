package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> forwardMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // this character has been encountered earlier
            // if this characters maps to the same character as last encounterd
            // this is ok; otherwise these strings are not isomorphic
            if (forwardMap.containsKey(c1)) {
                if (forwardMap.get(c1) != c2) {
                    return false;
                }
            } else { // this character has not been encountered
                // check if the character to which this character wants to map
                // has been claimed by some other character or not
                // if claimed then these strings are not isomorphic
                if (reverseMap.get(c2) != null) { // c2 is claimed
                    return false;
                } else { // both pair of characters are encountered for the 1st time
                    forwardMap.put(c1, c2);
                    reverseMap.put(c2, c1);
                }
            }
        }
        return true;
    }
}
