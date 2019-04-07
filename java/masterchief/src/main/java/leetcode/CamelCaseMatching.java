package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        String regex = createRegex(pattern);
        for (String q : queries) {
            if (q.matches(regex)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    private String createRegex(String pattern) {
        StringBuilder regex = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        String lowerCase = "[a-z]*";
        int i = 0;
        while (i < pattern.length()) {
            if (Character.isUpperCase(pattern.charAt(i))) {
                regex.append(sub.toString()).append(lowerCase);
                sub = new StringBuilder();
            }
            sub.append(pattern.charAt(i)).append(lowerCase);
            i++;
        }
        regex.append(sub.toString()).append(lowerCase);
        while (regex.length() != 0 && !Character.isUpperCase(regex.charAt(0))) {
            regex = regex.deleteCharAt(0);
        }
        return lowerCase + regex.toString();
    }

    public static void main(String[] args) {
        CamelCaseMatching c = new CamelCaseMatching();
        String fb = c.createRegex("FccBa");
        System.out.println(fb);
    }
}


// ["CompetitiveProgramming","CounterPick","ControlPanel"]
// "CooP"