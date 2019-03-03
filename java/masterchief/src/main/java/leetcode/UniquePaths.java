package leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int c = 1; c < m; c++) {
            dp[0][c] = 1;
        }
        for (int r = 1; r < n; r++) {
            dp[r][0] = 1;
        }
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }
        return dp[n-1][m-1];
    }
}
