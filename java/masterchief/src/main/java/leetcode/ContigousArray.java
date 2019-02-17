package leetcode;

import java.util.HashMap;

public class ContigousArray {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        if (nums.length == 0) {
            return 0;
        }
        // saves leftmost position of prefix sum
        HashMap<Integer, Integer> sumPos = new HashMap<>();
        sumPos.put(0, -1);
        sumPos.put(nums[0], 0);
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (sumPos.containsKey(nums[i])) {
                maxLen = Integer.max(maxLen, i - sumPos.get(nums[i]));
            } else {
                sumPos.put(nums[i], i);
            }
        }
        return maxLen;
    }
}
