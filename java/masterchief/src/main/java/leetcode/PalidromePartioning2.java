package leetcode;

/**
 * PalidromePartioning2
 */
public class PalidromePartioning2 {

    public int minCut(String s) {
        return countMinPal(s, 0) - 1;
    }

    private int countMinPal(String s, int start) {
        if(start == s.length()){
            return 0;
        }
        Integer min = Integer.MAX_VALUE;
        for(int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            if(isPal(subStr)) {
                min = Integer.min(min, 1 + countMinPal(s, i + 1));
            }
        }
        return min;
    }
    
    private boolean isPal(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalidromePartioning2 pp2 = new PalidromePartioning2();
        System.err.println(pp2.minCut("aa"));
    }
}