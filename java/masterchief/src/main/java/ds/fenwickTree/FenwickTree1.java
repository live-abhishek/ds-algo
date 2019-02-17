package ds.fenwickTree;

/**
 * This is a Fenwick tree implementation
 * with Point Updates & Range Queries
 */
public class FenwickTree1 {
    private int[] ft;

    public FenwickTree1(int [] arr, int size) {
        this.ft = new int[size + 1];
        // initialize ft with array elements
        for (int i = 1; i < this.ft.length; i++) {
            update(i, arr[i-1]);
        }
    }

    /**
     * update the fenwick tree
     * @param p index position in the array in question; 1-based indexing
     * @param v value in the array at that position
     */
    public void update(int p, int v) {
        for (; p < this.ft.length; p += p & -p) {
            this.ft[p] += v;
        }
    }

    /**
     * get the sum of the range inclusive
     * 1-based indexing
     * @param left
     * @param right
     */
    public int query(int left, int right) {
        return query(right) - query(left);
    }

    private int query(int p) {
        int sum = 0;
        for (; p > 0; p -= p & -p) {
            sum += this.ft[p];
        }
        return sum;
    }
}
