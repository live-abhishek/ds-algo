package leetcode;

public class MinimumDominoRotation {
    public int minDominoRotations(int[] A, int[] B) {
        int[] count = new int[7];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
            if (A[i] != B[i]) {
                count[B[i]]++;
            }
        }
        // if count doesn't have any number with value = n;
        // cannot solve
        int candidate = -1;
        for (int i = 1; i <= 6; i++) {
            if (count[i] == n) {
                candidate = i;
                break;
            }
        }
        // if candidate not found then return -1;
        if (candidate == -1) {
            return -1;
        }
        // found candidate
        int appInA = appearance(A, candidate);
        int appInB = appearance(B, candidate);
        return n - Integer.max(appInA, appInB);

    }

    private int appearance(int[] arr, int candidate) {
        int appearance = 0;
        for (int num : arr) {
            if (num == candidate) {
                appearance++;
            }
        }
        return appearance;
    }


}
