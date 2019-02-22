package leetcode;

import java.util.LinkedList;

public class NmberOfIsland {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    markIsland(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    private void markIsland(char[][] grid, int row, int col) {
        final int ROWS_INDEX = 0;
        final int COLS_INDEX = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int currRow = currPos[ROWS_INDEX];
            int currCol = currPos[COLS_INDEX];
            if (currRow > 0 && grid[currRow - 1][currCol] == '1') {
                grid[currRow - 1][currCol] = '0';
                queue.offer(new int[]{currRow - 1, currCol});
            }
            if (currRow < grid.length - 1 && grid[currRow + 1][currCol] == '1') {
                grid[currRow + 1][currCol] = '0';
                queue.offer(new int[]{currRow + 1, currCol});
            }
            if (currCol > 0 && grid[currRow][currCol - 1] == '1') {
                grid[currRow][currCol - 1] = '0';
                queue.offer(new int[]{currRow, currCol - 1});
            }
            if (currCol < grid[0].length - 1 && grid[currRow][currCol + 1] == '1') {
                grid[currRow][currCol + 1] = '0';
                queue.offer(new int[]{currRow, currCol + 1});
            }
        }
    }
}
