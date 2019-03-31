package leetcode;

import java.util.LinkedList;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        int ans = 0;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[r].length; c++) {
                if (A[r][c] == 1) { // this is a potential
                    // start flood fill; using bfs
                    LinkedList<int[]> q = new LinkedList<>();
                    q.addLast(new int[]{r, c});
                    boolean canGoOffLimits = false;
                    int currSize = 0;
                    A[r][c] = 2;
                    while (!q.isEmpty()) {
                        int[] curr = q.removeFirst();
                        currSize++;
                        int row = curr[0];
                        int col = curr[1];
                        if (row == 0 || row == A.length - 1 || col == 0 || col == A[0].length - 1) {
                            canGoOffLimits = true;
                        }
                        if (row > 0 && A[row - 1][col] == 1) {
                            q.addLast(new int[]{row-1, col});
                            A[row - 1][col] = 2;
                        }
                        if (row < A.length - 1 && A[row + 1][col] == 1) {
                            q.addLast(new int[]{row + 1, col});
                            A[row + 1][col] = 2;
                        }
                        if (col > 0 && A[row][col - 1] == 1) {
                            q.addLast(new int[]{row, col - 1});
                            A[row][col - 1] = 2;
                        }
                        if (col < A[0].length - 1 && A[row][col + 1] == 1) {
                            q.addLast(new int[]{row, col + 1});
                            A[row][col + 1] = 2;
                        }
                    }
                    if (!canGoOffLimits) {
                        ans += currSize;
                    }
                }
            }
        }
        return ans;
    }
}
