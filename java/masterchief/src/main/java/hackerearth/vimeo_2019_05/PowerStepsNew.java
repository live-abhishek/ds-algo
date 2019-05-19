package hackerearth.vimeo_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PowerStepsNew {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        List<long[]> queries = new ArrayList<>();
        long maxDiff = 0;
        for (int t = 0; t < T; t++) {
            long n = fr.nextLong();
            long u = fr.nextLong();
            long v = fr.nextLong();
            maxDiff = Long.max(maxDiff, Math.abs(v - u));
            long[] q = new long[]{n, u, v};
            queries.add(q);
        }
        List<Long> powerOfThrees = getPowerOfThrees(maxDiff);
        for (long[] q : queries) {
            long n = q[0];
            long u = q[1];
            long v = q[2];
            long cost = findCost(n, u, v, powerOfThrees);
            System.out.println(cost);
        }
    }

    private static List<Long> getPowerOfThrees(long upto) {
        List<Long> powerOfThrees = new ArrayList<>();
        powerOfThrees.add(1l);
        long current = 1;
        while (current < upto) {
            long newNum = current * 3;
            powerOfThrees.add(newNum);
            current = newNum;
        }
        return powerOfThrees;
    }

    private static long findCost(long n, long u, long v, List<Long> pot) {
        long diff = Math.abs(v - u);
        if (diff % 3 != 0) {
            return -1;
        }
        int cost = 0;
        while (diff > 0) {
            int index = getPowerOfThreeSmallerThanIndex(pot, diff);
            long num = pot.get(index);
            cost += index;
            diff = diff - num;
        }
        return cost;
    }

    private static int getPowerOfThreeSmallerThanIndex(List<Long> pot, long num) {
        int low = 0;
        int high = pot.size();
        while (low < high) {
            final int mid = (low + high) / 2;
            if (num < pot.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
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
