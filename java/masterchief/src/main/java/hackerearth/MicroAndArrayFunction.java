package hackerearth;

import java.io.*;
import java.util.*;

public class MicroAndArrayFunction {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int N = fr.nextInt();
            int K = fr.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = fr.nextInt();
            }
            Pair<Integer, Integer>[] pairs = new Pair[N];
            for (int i = 0; i < N; i++) {
                pairs[i] = new Pair<>(arr[i], i + 1);
            }
            Arrays.sort(pairs);
            BIT bit = new BIT(N + 1);
            int front = 0;
            long ans = 0;
            for (int i = 0; i < N; i++) {
                int cv = pairs[i].u;
                int idx = pairs[i].v;
                while (cv - pairs[front].u >= K) {
                    bit.update(pairs[front].v, pairs[front].v + 1);
                    front++;
                }
                ans += bit.query(idx) * (N - idx - 1);
            }
            bit = new BIT(N + 1);
            int back = N-1;
            for (int i = N - 1; i >= 0; i--) {
                int cv = pairs[i].u;
                int idx = pairs[i].v;
                while (pairs[back].u - cv >= K) {
                    bit.update(pairs[back].v, pairs[back].v + 1);
                    back--;
                }
                ans += bit.query(idx) * (N - idx - 1);
            }
            System.out.println(ans);
        }
    }

    static class BIT {
        private long[] tree;
        private int N;

        public BIT(int N) {
            this.N = N;
            this.tree = new long[N + 3];
        }

        public long query(int K) {
            long sum = 0;
            for (int i = K; i > 0; i -= i & -i) {
                sum += tree[i];
            }
            return sum;
        }

        public void update(int K, long val) {
            for (int i = K; i < tree.length; i += i & -i) {
                tree[i] += val;
            }
        }
    }

    static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        public final U u;
        public final V v;

        public Pair(U u, V v) {
            this.u = u;
            this.v = v;
        }

        public int hashCode() {
            return (u == null ? 0 : u.hashCode() * 31) + (v == null ? 0 : v.hashCode());
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<U, V> p = (Pair<U, V>) o;
            return (Objects.equals(u, p.u)) && (Objects.equals(v, p.v));
        }

        public int compareTo(Pair<U, V> b) {
            int cmpU = u.compareTo(b.u);
            return cmpU != 0 ? cmpU : v.compareTo(b.v);
        }

        @Override
        public String toString() {
            return "(" + this.u + ", " + this.v + ")";
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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
