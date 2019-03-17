package leetcode;

import java.util.Arrays;

public class KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = nums[1] - nums[0];
        int h = nums[n - 1] - nums[0];
        for (int i = 1; i < n; i++) {
            l = Integer.min(l, nums[i] - nums[i - 1]);
        }

        while (l < h) {
            int m = (l + h) >> 1;
            if (count(nums, m) < k) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

    public int count(int[] a, int val) {
        int n = a.length, res = 0;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n && a[j] - a[i] <= val) j++;
            res += j - i - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        KthSmallestPairDistance k = new KthSmallestPairDistance();
        int[] arr = {1,3,1};
        int a = k.smallestDistancePair(arr, 1);
        System.out.println(a);
    }
}
