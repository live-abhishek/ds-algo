package dpInterview.knapsack;

import java.util.Arrays;

public class TargetSum {

    private int findTargetSubsets(int[] num, int target) {
//        return findTargetSubsetsBottomUpDp(num, target);
        return findTargetSubsetMemoryOptimized(num, target);
    }

    private int findTargetSubsetsBottomUpDp(int[] num, int target) {
        int total = Arrays.stream(num).sum();
        if ((total + target) % 2 != 0 || total < target) {
            return 0;
        }
        int lookingFor = (total + target) / 2;
        int n = num.length;
        int[][] dp = new int[n][lookingFor + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int s = 0; s <= lookingFor; s++) {
            if (s == num[0]) {
                dp[0][s] += 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= lookingFor; s++) {
                if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s] + dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[n - 1][lookingFor];
    }

    private int findTargetSubsetMemoryOptimized(int[] num, int target) {
        int total = Arrays.stream(num).sum();
        if ((total + target) % 2 != 0 || total < target) {
            return 0;
        }
        int lookingFor = (total + target) / 2;
        int n = num.length;
        int[] dp = new int[lookingFor + 1];
        dp[0] = 1;
        for (int s = 0; s <= lookingFor; s++) {
            if (s == num[0]) {
                dp[s] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = lookingFor; s > 0; s--) {
                if (s >= num[i]) {
                    dp[s] = dp[s] + dp[s - num[i]];
                }
            }
        }
        return dp[lookingFor];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
