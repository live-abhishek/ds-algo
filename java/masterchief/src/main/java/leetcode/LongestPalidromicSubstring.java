package leetcode;

public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        // dp[i][j] is true if s[i...j] is palindromic
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1, startPos = 0;

        if(s.length() < 1) return "";

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

//        if(s.length() == 1) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                maxLen = 2;
                startPos = i;
            }
        }

        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (l > maxLen) {
                        startPos = i;
                        maxLen = l;
                    }
                }
            }
        }
        String palindrom = s.substring(startPos, startPos + maxLen);
        return palindrom;
    }

    public static void main(String[] args) {
        LongestPalidromicSubstring a = new LongestPalidromicSubstring();
        System.out.println(a.longestPalindrome("babad"));
        System.out.println(a.longestPalindrome("cbbd"));
        System.out.println(a.longestPalindrome(""));
        System.out.println(a.longestPalindrome("sa"));
        System.out.println(a.longestPalindrome("ss"));
        System.out.println(a.longestPalindrome("sss"));
        System.out.println(a.longestPalindrome("ssss"));
    }
}
