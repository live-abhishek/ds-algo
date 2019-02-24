package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int comp = target - num;
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(num, i);
        }
        return new int[]{};
    }
}
