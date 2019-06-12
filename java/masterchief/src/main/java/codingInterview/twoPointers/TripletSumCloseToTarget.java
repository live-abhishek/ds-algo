package codingInterview.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int firstPos = 0; firstPos < arr.length - 2; firstPos++) {
            int secondPos = firstPos + 1, thirdPos = arr.length - 1;
            while (secondPos < thirdPos) {
                int newSum = arr[firstPos] + arr[secondPos] + arr[thirdPos];
                int targetDiff = targetSum - newSum;
                if (targetDiff == 0) {
                    return targetSum;
                }
                if (targetDiff > 0) {
                    secondPos++;
                } else {
                    thirdPos--;
                }
                if (Math.abs(targetDiff) < Math.abs(smallestDiff)) {
                    smallestDiff = targetDiff;
                }
            }
        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
