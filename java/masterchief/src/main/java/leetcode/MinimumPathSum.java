package leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Integer.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
