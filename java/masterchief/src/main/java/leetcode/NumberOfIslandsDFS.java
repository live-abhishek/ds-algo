package leetcode;

public class NumberOfIslandsDFS {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    grid[row][col] = '0';
                    markIsland(grid, row, col);
                }
            }
        }
        return islandCount;
    };

    private void markIsland(char[][] grid, int row, int col) {
        if (row > 0 && grid[row - 1][col] == '1') {
            grid[row - 1][col] = '0';
            markIsland(grid, row - 1, col);
        }
        if (row < grid.length - 1 && grid[row + 1][col] == '1') {
            grid[row + 1][col] = '0';
            markIsland(grid, row + 1, col);
        }
        if (col > 0 && grid[row][col - 1] == '1') {
            grid[row][col - 1] = '0';
            markIsland(grid, row, col-1);
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == '1') {
            grid[row][col + 1] = '0';
            markIsland(grid, row, col+1);
        }
    }
}
