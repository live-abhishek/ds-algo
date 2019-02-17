package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqaureFullArrays {
    public int numSquarefulPerms(int[] A) {
        ArrayList<Integer> count = new ArrayList<>();
        count.add(0);
        Arrays.sort(A);
        permuteAndCount(A, new boolean[A.length], 0, count, -1);
        return count.get(0);
    }

    private void permuteAndCount(int[] A, boolean[] used, int charCount, List<Integer> sqaCount, int lastSelected){
        if (charCount == A.length) {
            sqaCount.set(0, sqaCount.get(0) + 1);
        }
        for (int i = 0; i < A.length; i++) {
            if(used[i] || i > 0 && A[i] == A[i-1] && !used[i-1]){
                continue;
            }
            if (lastSelected == -1 || isSquare(A[i], lastSelected)) {
                used[i] = true;
                permuteAndCount(A, used, charCount + 1, sqaCount, A[i]);
                used[i] = false;
            }
        }
    }


    private boolean isSquare(int a, int b) {
        double sqrt = Math.sqrt(a + b);
        return sqrt == Math.floor(sqrt);
    }

    public static void main(String[] args) {
        SqaureFullArrays s = new SqaureFullArrays();
        s.numSquarefulPerms(new int[]{0,0,1,1});
    }
}
