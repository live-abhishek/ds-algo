package codingInterview.slidingWindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int currSum = 0, minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < arr.length; r++) {
            currSum += arr[r];
            while (currSum >= S) {
                int currLen = r - l + 1;
                minLen = Integer.min(minLen, currLen);
                currSum -= arr[l];
                l++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
