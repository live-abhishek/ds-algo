package leetcode;

public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) {
            return false;
        }
        int N = matrix[0].length;
        int l = 0;
        int h = M * N;
        while (l < h) {
            int m = (l + h) / 2;
            int r = m / N, c = m % N;
            if(target == matrix[r][c]) {
                return true;
            } else if (target <= matrix[r][c]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
