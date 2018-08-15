package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SherlockAndValidString {
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(SherlockAndValidString.class.getClassLoader()
                .getResource("SherlockAndValidString/input.txt").getFile()));
        String str = sc.nextLine();
        System.out.println(isValid(str));
        sc.close();
    }

    static String isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        if (map.size() == 1) { // only 1 type of character
            return "YES";
        } else {
            // characters with only 1 occurrence
            List<Character> oneOccurrenceChars = map.keySet().stream()
                    .filter(c -> map.get(c) == 1)
                    .collect(Collectors.toList());
            if (oneOccurrenceChars.size() > 1) {
                return "NO";
            } else if (oneOccurrenceChars.size() == 1) {
                // only Character which occurs once
                char only = oneOccurrenceChars.get(0);
                // if all other character have same occurrence then it is valid
                int distinctOccurrences = map.keySet().stream()
                        .filter(c -> c != only)
                        .map(c -> map.get(c))
                        .collect(Collectors.toSet()).size();
                return distinctOccurrences == 1 ? "YES" : "NO";
            } else { // no character with one occurrence
                // minimum of all occurrences;
                int min = map.values().stream().mapToInt(v -> v).min().getAsInt();
                // this min should be equal to occurrence of all characters or
                // this min should be equal to occurrence of all but one characters,
                // and in that case
                // the difference with that character should be less than 2;
                // so if we subtract min with all occurrence and sum all these diffs
                // our sum should be less than 2; if not then not a valid string
                int sum = map.values().stream().mapToInt(v -> v - min).sum();
                return sum <= 1 ? "YES" : "NO";
            }
        }
    }
}
