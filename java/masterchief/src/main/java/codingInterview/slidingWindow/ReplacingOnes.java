package codingInterview.slidingWindow;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int oneCount = 0;
        int maxLen = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            if (arr[r] == 1) {
                oneCount++;
            }
            if (r - l + 1 - oneCount > k) {
                if (arr[l] == 1) {
                    oneCount--;
                }
                l++;
            }
            maxLen = Integer.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
