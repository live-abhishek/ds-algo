package ds;

public class SparseTable {
    int[][] spt;
    int[] log;

    SparseTable(int[] arr) {
        int exp = nextExponentOfTwo(arr.length);
        int len = 1 << exp;
        generateLogTable(len);
        generateSparseTable(arr, exp);
    }

    private void generateSparseTable(int[] arr, int exp) {
        spt = new int[exp + 1][];
        int firstRowSize = 1 << exp;
        spt[0] = new int[firstRowSize];
        for (int i = 0; i < firstRowSize; i++) {
            spt[0][i] = i < arr.length ? arr[i] : Integer.MAX_VALUE;
        }
        for (int r = 1; r < exp + 1; r++) {
            int lastRespSize = 1 << (r - 1);
            int currRespSize = 1 << r;
            int rowSize = firstRowSize - currRespSize + 1;
            spt[r] = new int[rowSize];
            for (int c = 0; c < rowSize; c++) {
                spt[r][c] = Integer.min(spt[r - 1][c], spt[r - 1][c + lastRespSize]);
            }
        }
    }

    /**
     * returns 7 -> 2, 8 -> 3, 9 -> 3
     * @param N
     */
    private void generateLogTable(int N) {
        this.log = new int[N + 1];
        log[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            log[i] = log[i / 2] + 1;
        }
    }

    /**
     * Gives min between ith & jth element. 0 based indexing both inclusive
     * @param i
     * @param j
     * @return
     */
    private int min(int i, int j) {
        int rangeSize = j - i + 1;
        int exp = this.log[rangeSize];
        int respSize = 1 << exp;
        return Integer.min(this.spt[exp][i], this.spt[exp][j - respSize + 1]);
    }

    /**
     * returns 7 -> 3, 8 -> 3, 9 -> 4
     * @param n
     * @return
     */
    private static int nextExponentOfTwo(int n) {
        return (int) Math.ceil(log2(n));
    }

    private static double log2(int n) {
        return Math.log(n)/Math.log(2);
    }

    public static void main(String[] args) {
        int[] ints = {4, 3, 7, 2, 3, 1, 5, 6, 7, 4, 8, 3, 7, 5, 1, 6};
        SparseTable spt = new SparseTable(ints);
        System.out.println(spt.min(3, 9));
        System.out.println(spt.min(0, 15));
        System.out.println(spt.min(6, 10));
        System.out.println(spt.min(6, 11));
    }
}
