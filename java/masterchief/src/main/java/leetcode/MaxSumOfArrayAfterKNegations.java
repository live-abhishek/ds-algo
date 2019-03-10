package leetcode;

import java.util.Arrays;

public class MaxSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        // first convert all -ve numbers to +ve
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K--;
            }
            if (K <= 0) {
                break;
            }
        }
        if (K <= 0) {
            return sum(A);
        }
        // now only positive nums are remaining and we can still do negations
        // find minimum
        int minIdx = minIndex(A);
        if (A[minIdx] == 0) {
            return sum(A);
        } else {
            if (K % 2 == 0) {
                return sum(A);
            } else {
                A[minIdx] = -A[minIdx];
                return sum(A);
            }
        }
    }

    private int minIndex(int[] arr) {
        int m = arr[0];
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < m) {
                m = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    private int sum(int[] arr){
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
}
