package dpInterview.fibonacci;

import java.util.Arrays;

public class StaircaseFee {
    private int findMinFee(int[] fee) {
        int[] dp = new int[fee.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = fee[0];
        for (int i = 4; i < dp.length; i++) {
            dp[i] = Integer.min(dp[i - 1] + fee[i - 1],
                    Integer.min(dp[i - 2] + fee[i - 2], dp[i - 3] + fee[i - 3]));
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        StaircaseFee sc = new StaircaseFee();
        int[] fee = { 1, 2, 5, 2, 1, 2 };
        System.out.println(sc.findMinFee(fee));
        fee = new int[] { 2, 3, 4, 5 };
        System.out.println(sc.findMinFee(fee));
    }
}