package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                integers.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] ans = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ans[i] = integers.get(i);
        }
        return ans;
    }
}
