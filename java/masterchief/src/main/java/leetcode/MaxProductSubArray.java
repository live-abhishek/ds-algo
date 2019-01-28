package leetcode;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int max = nums[0], positiveProd = nums[0], negativeProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int positive = positiveProd * nums[i];
            int negative = negativeProd * nums[i];
            positiveProd = Math.max(nums[i], Math.max(positive, negative));
            max = Integer.max(max, positiveProd);
            negativeProd = nums[i] < 0 ? Integer.min(nums[i], positive)
                    : Integer.min(nums[i], negative);
        }
        return max;
    }
}
