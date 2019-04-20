package leetcode;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int rot = getRotationLengthBinarySearch(nums);
        int origL, origR, l, r;
        origL = l = rot;
        origR = r = n+ rot;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target <= nums[m % n]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // if l lies between original L & R & nums[l % n] == target, return l
        return l >= origL && l < origR && nums[l % n] == target ? l % n : -1;
    }

    /**
     * e.g. 4, 1, 2, 3 returns 1 as length of rotation
     * e.g. 2, 3, 4, 1 returns 3 as length of rotation
     * Performs linear scan to find the rotation length
     * @param arr
     * @return
     */
    private int getRotationLength(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * e.g. 4, 1, 2, 3 returns 1 as length of rotation
     * e.g. 2, 3, 4, 1 returns 3 as length of rotation
     * Performs binary search to find the rotation of length
     * @param arr
     * @return
     */
    private int getRotationLengthBinarySearch(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= arr[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
