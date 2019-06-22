package dpInterview.knapsack;

public class SubsetSumCount {

    public int countSubsets(int[] num, int sum) {
//        return countSubsetsBottomUpDp(num, sum);
        return countSubsetsBottomUpDpMemoryOptimized(num, sum);
    }

    private int countSubsetsBottomUpDp(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int s = 0; s <= sum; s++) {
            if (s == num[0]) {
                dp[0][s] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s] + dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[n - 1][sum];
    }

    private int countSubsetsBottomUpDpMemoryOptimized(int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int s = 0; s <= sum; s++) {
            if(s == num[0]){
                dp[s] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = sum; s > 0; s--) {
                if (s >= num[i]) {
                    dp[s] += dp[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
