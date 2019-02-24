package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    q.offer(new int[]{r,c});
                } else {
                    matrix[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] currCell = q.poll();
            int row = currCell[0];
            int col = currCell[1];
            if (row > 0 && matrix[row - 1][col] > matrix[row][col] + 1) {
                matrix[row-1][col] = matrix[row][col] + 1;
                q.offer(new int[]{row - 1, col});
            }
            if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col] + 1) {
                matrix[row+1][col] = matrix[row][col] + 1;
                q.offer(new int[]{row + 1, col});
            }
            if (col > 0 && matrix[row][col - 1] > matrix[row][col] + 1) {
                matrix[row][col-1] = matrix[row][col] + 1;
                q.offer(new int[]{row, col - 1});
            }
            if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col] + 1) {
                matrix[row][col+1] = matrix[row][col] + 1;
                q.offer(new int[]{row, col + 1});
            }
        }
        return matrix;
    }
}
