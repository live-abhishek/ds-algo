package hackerearth.vimeo_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoringTree {

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int Q = fr.nextInt();
        int[] color = new int[N + 1];
        int[] parent = new int[N + 1];
        parent[0] = -1;
        parent[1] = -1;
        for (int i = 2; i < parent.length; i++) {
            parent[i] = i / 2;
        }
        int lastColor = 0;
        for (int q = 0; q < Q; q++) {
            int t = fr.nextInt();
            int v = fr.nextInt();
            if (t == 1) {
                int ans = findColor(parent, color, v);
                System.out.println(ans);
            } else {
                lastColor++;
                color[v] = lastColor;
            }
        }
    }

    private static int findColor(int[] parent, int[] color, int v) {
        int maxColorVal = color[v];
        while (v != -1) {
            maxColorVal = Integer.max(maxColorVal, color[v]);
            v = parent[v];
        }
        return maxColorVal;
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
