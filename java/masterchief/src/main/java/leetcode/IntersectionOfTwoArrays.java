package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums2) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] resArr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            resArr[i++] = num;
        }
        return resArr;
    }
}
