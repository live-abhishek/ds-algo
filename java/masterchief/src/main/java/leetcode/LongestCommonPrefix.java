package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0]; // considering 1st string as prefix
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // determine prefix by removing one character at a time from end
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
