package hackerearth.paletro_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddingPriorities {

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            int N = fr.nextInt();
            int M = fr.nextInt();
            long[][] matrix = new long[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    matrix[r][c] = fr.nextLong();
                }
            }
            solve(N, M, matrix);
        }
    }

    static void solve(int N, int M, long[][] matrix) {
        long p1 = calcSubMatrixPriority(matrix, 0, 0, N / 2, M / 2);
        long p2 = calcSubMatrixPriority(matrix, 0, M / 2, N / 2, M);
        long p3 = calcSubMatrixPriority(matrix, N / 2, M / 2, N, M);
        long p4 = calcSubMatrixPriority(matrix, N / 2, 0, N, M / 2);
        long newP1 = (p4 + p2) / 2;
        long newP2 = (p1 + p3) / 2;
        long newP3 = (p2 + p4) / 2;
        long newP4 = (p3 + p1) / 2;
        long origPriority = calcMatrixPriority(p1, p2, p3, p4);
        long newPriorityWithChangedP1 = calcMatrixPriority(newP1, p2, p3, p4);
        long newPriorityWithChangedP2 = calcMatrixPriority(p1, newP2, p3, p4);
        long newPriorityWithChangedP3 = calcMatrixPriority(p1, p2, newP3, p4);
        long newPriorityWithChangedP4 = calcMatrixPriority(p1, p2, p3, newP4);
        long ans = Long.min(origPriority,
                Long.min(newPriorityWithChangedP1,
                        Long.min(newPriorityWithChangedP2,
                                Long.min(newPriorityWithChangedP3, newPriorityWithChangedP4))));
        System.out.println(ans);
    }

    static long calcSubMatrixPriority(long[][] matrix,
              int startRow, int startCol, int endRow, int endCol) {
        long priority = 0;
        for (int r = startRow; r < endRow; r++) {
            for (int c = startCol; c < endCol; c++) {
                priority += matrix[r][c];
            }
        }
        return priority;
    }

    static long calcMatrixPriority(long p1, long p2, long p3, long p4) {
        long ans = Math.abs(p1 - p2) + Math.abs(p2 - p3)
                + Math.abs(p3 - p4) + Math.abs(p4 - p1);
        return ans;
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
