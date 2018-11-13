package codechef;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DOCSDEL {
    public static void main(String... args) throws Exception {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputStream inputStream = new FileInputStream(DOCSDEL.class.getClassLoader()
                .getResource("codechef/DOCSDEL.txt").getFile());
        // InputStream inputStream = System.in;
        FastScanner sc = new FastScanner(inputStream);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            solveTC(sc, out);
        }
    }

    static void solveTC(FastScanner sc, PrintWriter out){
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] p = new int[n][m];
        // reading permutations from input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = sc.nextInt() - 1;
            }
        }

        int[][] pref = new int[n][m], inv = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] cur = p[i];
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    pref[i][j] = inv[i][j] = cur[j];
                }
            } else {
                for (int j = 0; j < m; j++) {
                    pref[i][j] = cur[pref[i - 1][j]];
                    inv[i][j] = pref[i][j];
                }
            }
        }
        int[] tmp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[inv[i][j]] = j;
            }
            System.arraycopy(tmp, 0, inv[i], 0, m);
        }

        Map<Long, Long> result = new HashMap<>();
        int q = sc.nextInt();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = i;
        }
        for (int query = 0; query < q; query++) {
            int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
            long hash = (long) l * n + r;
            if(result.containsKey(hash)){
                out.println(result.get(hash));
                continue;
            }
            long curRes = 0;
            if(l == 0){
                int[] R = pref[r];
                for (int i = 0; i < m; i++) {
                    curRes += (long) (i+1) * (R[i]+1);
                }
            } else {
                int[] R = pref[r];
                int[] L = inv[l - 1];
                for (int i = 0; i < m; i++) {
                    curRes += (long) (i+1) * (R[L[i]]+1);
                }
            }
            out.println(curRes);
            result.put(hash, curRes);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }
}