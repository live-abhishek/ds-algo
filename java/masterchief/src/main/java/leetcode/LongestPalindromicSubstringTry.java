package leetcode;

public class LongestPalindromicSubstringTry {
    public String longestPalindrome(String s) {
        return null;
    }

    private String longestSubstring(String s1, String s2){
        Cell[][] dpArray = createDpArray(s1, s2);
        return null;
    }

    private String findLongestCommon(Cell[][] dpArray, String s1, String s2) {
        for (int i = dpArray.length - 1; i >= 0; i++) {
            for (int j = dpArray[0].length - 1; j >= 0; j++) {
            }
        }
        return null;
    }

    private Cell[][] createDpArray(String s1, String s2) {
        Cell[][] dp = new Cell[s2.length() + 1][s1.length() + 1];
        // initialize dp table
        for (int i = 0; i < s2.length() + 1; i++) {
            for (int j = 0; j < s1.length() + 1; j++) {
                dp[i][j] = new Cell();
            }
        }
        for (int i = 1; i < s2.length() + 1; i++) {
            for (int j = 1; j < s1.length() + 1; j++) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    dp[i][j].val = dp[i-1][j-1].val + 1;
                    dp[i][j].dir = Direction.cross;
                } else {
                    if (dp[i - 1][j].val > dp[i][j - 1].val) {
                        dp[i][j].val = dp[i - 1][j].val;
                        dp[i][j].dir = Direction.up;
                    } else {
                        dp[i][j].val = dp[i][j-1].val;
                        dp[i][j].dir = Direction.left;
                    }
                }
            }
        }
        return dp;
    }

    static enum Direction{
        cross, left, up
    }

    static class Cell{
        int val;
        Direction dir;
        Cell(){
            val = 0;
            dir = null;
        }
    }

}
