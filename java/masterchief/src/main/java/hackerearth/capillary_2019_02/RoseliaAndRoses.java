package hackerearth.capillary_2019_02;

import java.io.*;
import java.util.StringTokenizer;

public class RoseliaAndRoses {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = fr.nextInt();
            }
            solveTC(arr);
        }
    }

    private static void solveTC(int[] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0]);
        } else if (arr.length == 2) {
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            dp[1] = Integer.max(arr[1], dp[0]-arr[1]);
            System.out.println(dp[1]);
        } else if (arr.length == 3) {
            int maxEven = arr[0];
            int maxOdd = Integer.max(arr[1], arr[0] - arr[1]);
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            dp[1] = Integer.max(arr[1], dp[0]-arr[1]);
            for (int i = 2; i < arr.length; i++) {
                if (i % 2 == 0) {
                    dp[i] = Integer.max(arr[i], Integer.max(maxEven + arr[i], maxOdd - arr[i]));
                    maxEven = Integer.max(maxEven, dp[i]);
                } else {
                    dp[i] = Integer.max(arr[i], Integer.max(maxOdd + arr[i], maxEven - arr[i]));
                    maxOdd = Integer.max(maxOdd, dp[i]);
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws Exception {
//            br = new BufferedReader(new InputStreamReader(System.in));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(RoseliaAndRoses.class.getClassLoader()
                    .getResource("hackerearth/capillary_2019_02/RoseliaAndRoses.txt").getFile())));
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
