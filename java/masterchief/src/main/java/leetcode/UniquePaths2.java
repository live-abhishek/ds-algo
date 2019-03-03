package leetcode;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int c = 1; c < obstacleGrid[0].length; c++) {
            if (obstacleGrid[0][c] == 0) {
                dp[0][c] = dp[0][c - 1];
            } else {
                dp[0][c] = 0;
            }
        }
        for (int r = 1; r < obstacleGrid.length; r++) {
            if (obstacleGrid[r][0] == 0) {
                dp[r][0] = dp[r - 1][0];
            } else {
                dp[r][0] = 0;
            }
        }
        for (int r = 1; r < obstacleGrid.length; r++) {
            for (int c = 1; c < obstacleGrid[0].length; c++) {
                if (obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                } else {
                    dp[r][c] = 0;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
