package hackerearth.wissen_2019_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FindingSubarray {

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fr.nextInt();
        }
        solve(arr);
    }

    private static void solve(int[] arr) {
        List<int[]> subArrays = new ArrayList<>();
        long wholeSum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            long currSubArraySum = 0;
            for (int j = i; j < arr.length; j++) {
                currSubArraySum += arr[j];
                int currSize = (j - i + 1);
                long remainSum = wholeSum - currSubArraySum;
                int remainSize = arr.length - ((j - i) + 1);
                if (remainSize == 0) {
                    subArrays.add(new int[]{i,j});
                } else {
                    if ((currSubArraySum * remainSize) > (remainSum * currSize)) {
                        subArrays.add(new int[]{i,j});
                    }
                }
            }
        }
        System.out.println(subArrays.size());
        for (int[] subArray : subArrays) {
            System.out.println((subArray[0] + 1) + " " + (subArray[1] + 1));
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
