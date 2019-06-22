package dpInterview.knapsack;

import java.util.Arrays;

public class PartitionSetEqualSum {


    private boolean canPartition(int[] num) {
        return canPartitionBottomUpDp(num);
    }

    private boolean canPartitionRecursive(int[] num) {
        return false;
    }

    private boolean canPartitionTopDownDp(int[] num) {
        return false;
    }

    private boolean canPartitionBottomUpDp(int[] num) {
        int sum = Arrays.stream(num).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = num.length;
        int pSum = sum / 2;
        boolean[][] dp = new boolean[n][pSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int s = 1; s <= pSum; s++) {
            if (num[0] == s) {
                dp[0][s] = true;
            } else {
                dp[0][s] = false;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= pSum; s++) {
                if(num[i] > s){
                    dp[i][s] = dp[i-1][s];
                } else {
                    dp[i][s] = dp[i-1][s] || dp[i-1][s - num[i]];
                }
            }
        }

        return dp[n-1][pSum];
    }

    public static void main(String[] args) {
        PartitionSetEqualSum ps = new PartitionSetEqualSum();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
