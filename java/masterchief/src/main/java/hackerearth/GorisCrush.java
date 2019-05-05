package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GorisCrush {

    final static int MAX = 1000000010;

    public static void update(Map<Integer, Integer> BIT, int x, int v) {
        while (x < MAX) {
            BIT.put(x, BIT.getOrDefault(x, 0) + v);
            x += x & -x;
        }
    }

    public static int query(Map<Integer, Integer> BIT, int x) {
        int val = 0;
        while (x > 0) {
            val += BIT.getOrDefault(x, 0);
            x -= x & -x;
        }
        return val;
    }

    public static int query(Map<Integer, Integer> BIT, int start, int end) {
        return query(BIT, end) - query(BIT, start - 1);
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int Q = fr.nextInt();
        int k = fr.nextInt();
        int[] fortune = new int[N+1];
        Map<Integer, Integer> BIT = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            fortune[i] = fr.nextInt();
            update(BIT, fortune[i], 1);
        }
        for (int i = 0; i < Q; i++) {
            int queryType = fr.nextInt();
            if (queryType == 0) {
                int x = fr.nextInt();
                int y = fr.nextInt();
                update(BIT, fortune[x], -1);
                fortune[x] = y;
                update(BIT, fortune[x], 1);
            } else {
                int a = fr.nextInt();
                int b = fr.nextInt();
                int c = fr.nextInt();
                int d = fr.nextInt();

                int matchVal = 0;
                if (a > d || c > b) {
                    matchVal = 0;
                } else if (a >= c && b <= d) {
                    matchVal = query(BIT, a, b);
                } else if (c >= a && d <= b) {
                    matchVal = query(BIT, c, d);
                } else if (c >= a && b <= d) {
                    matchVal = query(BIT, c, b);
                } else if (a >= c && d <= b) {
                    matchVal = query(BIT, a, d);
                }
                if (matchVal >= k) {
                    System.out.println("Propose");
                } else {
                    System.out.println("Do not propose");
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
