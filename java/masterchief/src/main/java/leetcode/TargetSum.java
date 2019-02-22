package leetcode;

public class TargetSum {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    private void dfs(int[] nums, int pos, int sum, int target){
        if (pos >= nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, pos + 1, sum + nums[pos], target);
            dfs(nums, pos + 1, sum - nums[pos], target);
        }
    }
}
