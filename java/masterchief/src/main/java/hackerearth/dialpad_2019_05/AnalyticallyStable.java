package hackerearth.dialpad_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnalyticallyStable {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            String number = fr.next();
            solveTC(number);
        }
    }

    private static void solveTC(String number) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            map.get(c - '0').add(i);
        }
        int totalCount = 0;
        for (int i = 0; i < 9; i++) {
            if (map.get(i).size() > 1 && map.get(i + 1).size() > 1) {
                List<Integer> smallerPos = map.get(i);
                List<Integer> largerPos = map.get(i + 1);
                int count = getCount(smallerPos, largerPos);
                totalCount += count;
                totalCount %= MOD;
            }
        }
        System.out.println(totalCount);
    }

    private static int getCount(List<Integer> smallerPos, List<Integer> largerPos) {
        long count = 0;
        for (int i = 1; i < smallerPos.size(); i++) {
            int numX1Pos = greaterCount(largerPos, smallerPos.get(i));
            if (numX1Pos < 2) {
                continue;
            }
            count += i * binCoeff(numX1Pos, 2);
            count %= MOD;
        }
        return (int)count;
    }

    private static long binCoeff(int n, int r) {
        long res = 1;
        if (r > n - r) {
            r = n - r;
        }
        for (int i = 0; i < r; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res % MOD;
    }

    private static int greaterCount(List<Integer> list, int k) {
        int l = 0;
        int r = list.size() - 1;
        int greater = list.size();

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) > k) {
                greater = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return list.size() - greater;
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
