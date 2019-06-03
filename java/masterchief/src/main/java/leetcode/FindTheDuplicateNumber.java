package leetcode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int pos = num - 1;
            if (nums[pos] < 0) {
                return num;
            } else {
                nums[pos] = -nums[pos];
            }
        }
        return -1;
    }
}
