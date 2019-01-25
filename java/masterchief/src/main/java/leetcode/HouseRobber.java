package leetcode;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Integer.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Integer.max(dp[i-2], dp[i-3]);
        }
        return Integer.max(dp[dp.length-1], dp[dp.length-2]);
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] ints = {2, 7, 9, 3, 1};
        int ans = h.rob(ints);
        System.out.println(ans);
    }
}
