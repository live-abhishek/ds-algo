package dpInterview.knapsack;

public class SubsetSum {

    public boolean canPartition(int[] num, int sum) {
//        return canPartitionBottomUpDp(num, sum);
        return canPartitionBottomUpMemoryOptimized(num, sum);
    }

    private boolean canPartitionBottomUpDp(int[] num, int sum) {
        int n = num.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s = 0; s <= sum; s++) {
            if (num[0] == s) {
                dp[0][s] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[n - 1][sum];
    }

    private boolean canPartitionBottomUpMemoryOptimized(int[] num, int sum) {
        int n = num.length;
        boolean[] dp = new boolean[sum + 1];
        for (int s = 0; s <= sum; s++) {
            if (num[0] == s) {
                dp[s] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = sum; s > 0; s--) {
                if (s >= num[i]) {
                    dp[s] = dp[s] || dp[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 2, 3, 7};
        System.out.println(ss.canPartition(num, 6));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.canPartition(num, 10));
        num = new int[]{1, 3, 4, 8};
        System.out.println(ss.canPartition(num, 6));
    }
}
