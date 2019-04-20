package leetcode;

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = binarySearch(nums, target);
        if (lowerBound < nums.length && nums[lowerBound] == target) {
//            int upperBound = binarySearchUpperBound(nums, target);
            int upperBound = binarySearch(nums, target + 1);
            return new int[]{lowerBound, upperBound - 1};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target <= nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int binarySearchUpperBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target < nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
