package codingInterview.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        // map of character their frequency in the sliding window
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < arr.length; r++) {
            char c = arr[r];
            addFruit(map, c);
            while (map.size() > 2) {
                char leftFruit = arr[l];
                removeFruit(map, leftFruit);
                l++;
            }
        }
        return map.values().stream().mapToInt(i -> i).sum();
    }

    private static void addFruit(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void removeFruit(Map<Character, Integer> map, Character character) {
        Integer count = map.getOrDefault(character, 0);
        if (count > 1) {
            map.put(character, count - 1);
        } else {
            map.remove(character);
        }
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
