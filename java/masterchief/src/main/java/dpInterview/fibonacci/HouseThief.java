package dpInterview.fibonacci;

public class HouseThief {
    public int findMaxSteal(int[] wealth) {
        int[] dp = new int[wealth.length + 1];
        dp[0] = 0;
        dp[1] = wealth[0];
        dp[2] = wealth[1];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Integer.max(dp[i - 2], dp[i - 3]) + wealth[i - 1];
        }
        return Integer.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}
