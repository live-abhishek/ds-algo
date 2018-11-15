package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MINIONS {

    public static class SegmentTree {
        long[] st;
        int n;

        public SegmentTree(int n){
            st = new long[4 * n];
            this.n = n;
        }

        void build(int i, int[] a, int r1, int r2){
            if(r1 == r2){
                st[i] = a[r1];
            } else {
                build(i*2+1, a, r1, (r1+r2)/2);
                build(i*2+2, a, (r1+r2)/2 + 1, r2);

                st[i] = st[i*2 + 1] + st[i*2 + 2];
            }
        }

        long query(int i, int ra, int rb, int r1, int r2){
            if(ra > r2 || rb < r1){
                return 0;
            }
            if(ra >= r1 && rb <= r2){
                return st[i];
            }
            long p1 = query(i*2+1, ra, (ra+rb)/2, r1, r2);
            long p2 = query(i*2+2, (ra+rb)/2+1, rb, r1, r2);
            return p1+p2;
        }

        long update(int i, int ra, int rb, int ind, long val){
            if(ra == rb && rb == ind){
                st[i] = val;
                return st[i];
            }
            if(ra > ind || rb < ind){
                return st[i];
            }
            long p1 = update(i*2+1, ra, (ra+rb)/2, ind, val);
            long p2 = update(i*2+2, (ra+rb)/2+1, rb ,ind, val);
            return st[i] = p1 + p2;
        }
    }

    public static class Min {
        int a, b, i;
        public Min(int a, int b, int i){
            this.a = a; this.b = b; this.i = i;
        }
        public Min(Min other){
            a = other.a; b = other.b; i = other.i;
        }
    }

    public static void main(String... args) throws IOException {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputStream inputStream = System.in;
        FastScanner sc = new FastScanner(inputStream);
        int t = sc.nextInt();
        while(t-- > 0){
            solve(sc, out);
        }
        out.close();
        sc.close();
    }

    static void solve(FastScanner sc, PrintWriter out){
        int n = sc.nextInt();

        Min[] min = new Min[n];
        Min[] min2 = new Min[n];

        for(int i = 0; i < n; i++){
            min[i] = new Min(sc.nextInt(), sc.nextInt(), i);
            min2[i] = new Min(min[i]);
        }

        Arrays.sort(min, (m1, m2) -> m1.a - m2.a);
        Arrays.sort(min2, (m1, m2) -> m1.b - m2.b);

        int[] bMap = new int[n];
        for(int i = 0; i < n; i++){
            bMap[min[i].i] = i;
        }

        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            b[i] = min2[i].b;
        }

        int[] c = new int[n];
        Arrays.fill(c, 1);

        SegmentTree cst = new SegmentTree(n);
        SegmentTree sst = new SegmentTree(n);

        cst.build(0, c, 0, n-1);
        sst.build(0, b, 0, n-1);

        List<Integer> li = new ArrayList<>();
        long fans = 0;
        for(int i = 0; i < n; i++){
            if(i > 0 && min[i].a > min[i-1].a){
                for(int j = 0; j < li.size(); j++){
                    cst.update(0, 0, n-1, li.get(j), 0);
                    sst.update(0, 0, n-1, li.get(j), 0);
                }
            }
            int mina = min[i].a;
            int lo = 0;
            int hi = n - 1;
            long ans = 0;
            while(lo <= hi){
                
            }
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

        public void close() throws IOException {
            br.close();
        }
    }
}