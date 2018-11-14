package codechef;

import java.io.*;
import java.util.StringTokenizer;

public class fctrl {

    public static void main(String[] args) throws IOException {
//        InputStream ins = new FileInputStream(HMAPPY.class.getClassLoader()
//                .getResource("codechef/fctrl.txt").getFile());
        InputStream ins = System.in;
        FastScanner sc = new FastScanner(ins);
        OutputStream ops = System.out;
        PrintWriter pw = new PrintWriter(ops);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve(sc, pw);
        }
        sc.close(); pw.close();
    }

    private static void solve(FastScanner sc, PrintWriter pw) {
        long n = sc.nextLong();
        long ans = 0;
        long pow = 1;
        double powOf5 = Math.pow(5, pow);
        while (powOf5 <= n) {
            ans += n / powOf5;
            pow++;
            powOf5 = Math.pow(5, pow);
        }
        pw.println(ans);
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

        public long nextLong() {
            return Long.parseLong(next());
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

        public void close() throws IOException {
            br.close();
        }
    }
}
