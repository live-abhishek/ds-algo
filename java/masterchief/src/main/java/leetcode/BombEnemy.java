package leetcode;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int R = grid.length;
        int C = grid[0].length;
        int[][] up = new int[R][C];
        int[][] down = new int[R][C];
        int[][] left = new int[R][C];
        int[][] right = new int[R][C];
        
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(r == 0) {
                    up[r][c] = grid[r][c] == 'E' ? 1 : 0;
                } else {
                    if(grid[r][c] == 'W') {
                        up[r][c] = 0;
                    } else if(grid[r][c] == '0') {
                        up[r][c] = up[r-1][c];
                    } else {
                        up[r][c] = 1 + up[r-1][c];
                    }
                }
            }
        }
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(c == 0) {
                    left[r][c] = grid[r][c] == 'E' ? 1 : 0;
                } else {
                    if(grid[r][c] == 'W') {
                        left[r][c] = 0;
                    } else if(grid[r][c] == '0') {
                        left[r][c] = left[r][c-1];
                    } else {
                        left[r][c] = 1 + left[r][c-1];
                    }
                }
            }
        }
        for(int r = R-1; r >= 0; r--) {
            for(int c = C-1; c >= 0; c--) {
                if(r == R - 1) {
                    down[r][c] = grid[r][c] == 'E' ? 1 : 0;
                } else {
                    if(grid[r][c] == 'W') {
                        down[r][c] = 0;
                    } else if(grid[r][c] == '0') {
                        down[r][c] = down[r+1][c];
                    } else {
                        down[r][c] = 1 + down[r+1][c];
                    }
                }
            }
        }
        for(int r = R-1; r >= 0; r--) {
            for(int c = C-1; c >= 0; c--) {
                if(c == C - 1 ) {
                    right[r][c] = grid[r][c] == 'E' ? 1 : 0;
                } else {
                    if(grid[r][c] == 'W') {
                        right[r][c] = 0;
                    } else if(grid[r][c] == '0') {
                        right[r][c] = right[r][c+1];
                    } else {
                        right[r][c] = 1 + right[r][c+1];
                    }
                }
            }
        }
        
        int ans = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '0') {
                    int b = 0;
                    if(r > 0) {
                        b += up[r-1][c];
                    }
                    if(r < R - 1) {
                        b += down[r+1][c];
                    }
                    if(c > 0) {
                        b += left[r][c-1];
                    }
                    if(c < C - 1) {
                        b += right[r][c+1];
                    }
                    ans = Integer.max(ans, b);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BombEnemy b = new BombEnemy();
        char[][] grid = {
            {'0', 'E', '0', '0'},
            {'E', '0', 'W', 'E'},
            {'0', 'E', '0', '0'}
        };
        int ans = b.maxKilledEnemies(grid);
        System.out.println(ans);
    }
}
