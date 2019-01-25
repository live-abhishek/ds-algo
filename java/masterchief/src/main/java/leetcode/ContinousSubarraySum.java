package leetcode;

import java.util.HashSet;

public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        // if any consecutive numbers are zero, then it is true
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i+1] == 0) return true;
        }
        if(k == 0) return false;
        k = Math.abs(k);
        HashSet<Integer> set = new HashSet<>();
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k;
            if(runningSum == 0 && nums[i] != k)
                return true;
            if(set.contains(runningSum) && nums[i] != 0)
                return true;
            set.add(runningSum);
        }
        return false;
    }

    public static void main(String[] args) {
        ContinousSubarraySum c = new ContinousSubarraySum();
        c.checkSubarraySum(new int[] {1,2,3}, 5);
    }
}
