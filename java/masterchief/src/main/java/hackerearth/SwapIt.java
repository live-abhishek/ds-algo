package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SwapIt {
    public static void main(String args[] ) throws Exception {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            int l = fr.nextInt();
            int k = fr.nextInt();
            int[] arr = new int[l];
            for (int j = 0; j < l; j++) {
                arr[j] = fr.nextInt();
            }
            minimal(arr, k);
        }
    }

    private static void minimal(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n - 1 && k > 0; i++) {
            int pos = i; // position of smallest element which will be brought forward
            for (int j = i + 1; j < n; j++) {
                if (j - i > k) {
                    break;
                }
                // get the element which is smallest
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int temp;
            for (int j = pos; j > i; j--) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            k -= pos - i;
        }
        System.out.println(Arrays.stream(arr)
            .mapToObj(i -> Integer.toString(i))
                .collect(Collectors.joining(" ")));
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
