package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PalindromePartitioning
 */
public class PalindromePartitioning {
    List<List<String>> ans = new ArrayList<>();
    String s;
    
    public List<List<String>> partition(String s) {
        this.s = s;
        genPal(new ArrayList<>(), 0);
        return ans;
    }
    
    private void genPal(List<String> t, int start) {
        if(start == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i+1);
            if(isPal(subStr)){
                t.add(subStr);
                genPal(t, i + 1);
                t.remove(t.size() - 1);
            }
        }
    }
    
    private boolean isPal(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> ans = pp.partition("aab");
        ans.stream().forEach(ls -> System.out.println(ls.stream().collect(Collectors.joining(","))));
    }
}