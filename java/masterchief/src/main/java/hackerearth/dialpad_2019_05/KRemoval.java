package hackerearth.dialpad_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KRemoval {

    static class Pointer {
        int left, mid, right;

        public Pointer(int left, int mid, int right) {
            this.left = left;
            this.mid = mid;
            this.right = right;
        }
    }


    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int K = fr.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }
        int origDiff = 0;
        for (int i = 0; i < N - 1; i++) {
            origDiff += Math.abs(arr[i] - arr[i+1]);
        }
        int newDiff = origDiff;
        for (int i = 0; i < K; i++) {
            newDiff = getMaxDiff(arr, newDiff);
        }
        System.out.println(newDiff);
    }

    private static int getMaxDiff(int[] arr, int origDiff){
        int maxPossibleDiff = -1;
        int maxPossibleDiffPos = -1;
        Pointer currPointer = getStartPointer(arr);
        while (currPointer.right != -1) {
            if (currPointer.left == -1) {
                int midVal = arr[currPointer.mid];
                int rightVal = arr[currPointer.right];
                int possibleDiff = Math.abs(midVal - rightVal);
                if (maxPossibleDiff < possibleDiff) {
                    maxPossibleDiff = possibleDiff;
                    maxPossibleDiffPos = currPointer.mid;
                }
            } else {
                int leftVal = arr[currPointer.left];
                int rightVal = arr[currPointer.right];
                int midVal = arr[currPointer.mid];
                int diffLM = Math.abs(leftVal - midVal);
                int diffMR = Math.abs(midVal - rightVal);
                int diffLR = Math.abs(leftVal - rightVal);
                int possibleDiff = origDiff - diffLM - diffMR + diffLR;
                if (maxPossibleDiff < possibleDiff) {
                    maxPossibleDiff = possibleDiff;
                    maxPossibleDiffPos = currPointer.mid;
                }
            }
            currPointer = getNextPointer(arr, currPointer);
        }
        if (currPointer.left != -1) {
            int leftVal = arr[currPointer.left];
            int midVal = arr[currPointer.mid];
            int possibleDiff = Math.abs(leftVal - midVal);
            if (maxPossibleDiff < possibleDiff) {
                maxPossibleDiff = possibleDiff;
                maxPossibleDiffPos = currPointer.mid;
            }
        }
        arr[maxPossibleDiffPos] = 0;
        return maxPossibleDiff;
    }

    private static Pointer getNextPointer(int[] arr, Pointer currPointer) {
        int newRight = -1;
        for (int i = currPointer.right + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                newRight = i;
                break;
            }
        }
        currPointer.left = currPointer.mid;
        currPointer.mid = currPointer.right;
        currPointer.right = newRight;
        return currPointer;
    }

    private static Pointer getStartPointer(int[] arr) {
        int mid = -1;
        int left = -1;
        int right = -1;
        // assigned mid to first possible element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                mid = i;
                break;
            }
        }
        // assign right to next possible element
        for (int i = mid + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                right = i;
                break;
            }
        }
        return new Pointer(left, mid, right);
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
