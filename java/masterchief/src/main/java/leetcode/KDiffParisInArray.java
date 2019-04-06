package leetcode;

import java.util.HashMap;

public class KDiffParisInArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (Integer i : map.keySet()) {
            int other = i - k;
            if(map.containsKey(other)) {
                if (k == 0) {
                    if (map.get(i) > 1) {
                        count += 1;
                    }
                } else {
                    count += 1;
                }
            }
        }
        return count;
    }
}
