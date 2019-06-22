package dpInterview.knapsack;

import java.util.Arrays;

public class PartitionSetMinDiff {

    public int canPartition(int[] num) {
        return canPartitionBottomUpDp(num);
    }

    private int canPartitionBottomUpDp(int[] num) {
        int sum = Arrays.stream(num).sum();
        int n = num.length;
        int upto = sum / 2;
        boolean[][] dp = new boolean[n][upto + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s = 0; s <= upto; s++) {
            if (s == num[0]) {
                dp[0][s] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= upto; s++) {
                if (s >= num[i]) {
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - num[i]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        int sum1 = 0;
        for (int s = upto; s >= 0; s--) {
            if (dp[n - 1][s]) {
                sum1 = s;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

    public static void main(String[] args) {
        PartitionSetMinDiff ps = new PartitionSetMinDiff();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
