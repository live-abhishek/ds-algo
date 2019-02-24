package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int minPos = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                minPos = Integer.min(minPos, entry.getValue().get(0));
            }
        }
        return minPos == Integer.MAX_VALUE ? -1 : minPos;
    }
}
