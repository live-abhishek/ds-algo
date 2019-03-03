package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> mainCounter = getCounter(A[0]);
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> counter = getCounter(A[i]);
            // remove those keys which are not present in the other one
            mainCounter.keySet().retainAll(counter.keySet());
            for (Map.Entry<Character, Integer> entry : mainCounter.entrySet()) {
                entry.setValue(Integer.min(entry.getValue(), counter.get(entry.getKey())));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : mainCounter.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey().toString());
            }
        }
        return result;
    }

    private Map<Character, Integer> getCounter(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0)+1);
        }
        return counter;
    }

    public static void main(String[] args) {
        FindCommonCharacters f = new FindCommonCharacters();
        String[] strs = {"bella","label","roller"};
        List<String> strings = f.commonChars(strs);
        System.out.println(strings);
    }
}
