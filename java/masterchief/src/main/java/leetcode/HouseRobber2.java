package leetcode;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Integer.max(nums[0], nums[1]);
        if(nums.length == 3) return Integer.max(nums[0], Integer.max(nums[1], nums[2]));
        int max;
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }
        max = Integer.max(dp[dp.length -1], dp[dp.length - 2]);
        dp[0] = nums[1];
        dp[1] = nums[2];
        dp[2] = dp[0] + nums[3];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i + 1], dp[i - 3] + nums[i + 1]);
        }
        max = Integer.max(max, Integer.max(dp[dp.length -1], dp[dp.length - 2]));
        return max;
    }

}
