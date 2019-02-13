package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairCharacter {
    public static void main(String[] args) {
        String input = "This is a sample statement. Use it for testing the program for finding the hidden pairs";
        Map<String, Integer> map = new HashMap<>();
        input = input.toLowerCase();
        // sanitize input
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                chars.add(ch);
            }
        }

        for (int i = 0; i < chars.size() - 1; i++) {
            if (chars.get(i + 1) - chars.get(i) == 1) {
                String str = chars.get(i) + "" + chars.get(i + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        for ( Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
