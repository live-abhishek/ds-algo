package leetcode;

import java.util.Arrays;

public class PartitionKEqualSubsets {
    enum Result{TRUE, FALSE}
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;

        Result[] memo = new Result[1 << nums.length];
        memo[1 << nums.length - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }
    
    private boolean search(int used, int sum, Result[] memo, int[] nums, int target) {
        if(memo[used] == null) {
            memo[used] = Result.FALSE;
            int lookingFor = (sum % target) == 0 ? target :  sum % target;
            for(int i = 0; i < nums.length; i++) {
                boolean iUnsused = ((used >> i) & 1) == 0;
                if(iUnsused && nums[i] <= lookingFor) {
                    if(search(used | 1 << i, sum - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }

    public static void main(String[] args) {
        PartitionKEqualSubsets p = new PartitionKEqualSubsets();
        int[] nums = {4,3,2,3,5,2,1};
        boolean ans = p.canPartitionKSubsets(nums, 4);
        System.out.println(ans);
    }
}