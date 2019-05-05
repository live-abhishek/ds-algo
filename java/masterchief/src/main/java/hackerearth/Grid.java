package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Grid {
    static int OCCUPIED = -2;
    static int FREE = -1;
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int Q = fr.nextInt();

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            String str = fr.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j) == '*' ? OCCUPIED : FREE;
            }
        }
        int si = fr.nextInt() - 1;
        int sj = fr.nextInt() - 1;
        findDistances(grid, si, sj);
        for (int i = 0; i < Q; i++) {
            int di = fr.nextInt() - 1;
            int dj = fr.nextInt() - 1;
            System.out.println(grid[di][dj] >= 0 ? grid[di][dj] : -1);
        }
    }

    private static void findDistances(int[][] grid, int si, int sj) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        grid[si][sj] = 0;
        queue.add(new int[]{si, sj});
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int currRow = curr[0];
            int currCol = curr[1];
            for (int[] dir : dirs) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (newRow >= 0 && newRow < totalRows
                        && newCol >= 0 && newCol < totalCols
                        && grid[newRow][newCol] == FREE) {
                    grid[newRow][newCol] = grid[currRow][currCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws Exception {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
