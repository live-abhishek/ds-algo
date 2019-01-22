package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // number we saw, will be used as index
            int numberSeen = Math.abs(nums[i]);
            // absolute value at that index
            int val = Math.abs(nums[numberSeen - 1]);
            nums[numberSeen - 1] = -val;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
