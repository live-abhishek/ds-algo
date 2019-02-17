package ds.fenwickTree;

/**
 * This is a Fenwick tree implementation
 * with Range Updates & Point Queries
 */
public class FenwickTree2 {
    private int[] arr;
    private int[] ft;

    public FenwickTree2(int[] arr){
        this.arr = new int[arr.length + 1];
        // insert extra 0 at the start of the base array
        for (int i = 1; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
        // ft arr is initialized with zeroes
        this.ft = new int[arr.length + 1];
    }

    public void update(int left, int right, int v) {
        this.update(left, v);
        this.update(right + 1, -v);
    }

    public void update(int p, int v) {
        for (; p <= this.ft.length; p += p & -p) {
            this.ft[p] += v;
        }
    }

    /**
     * Query for value at that position
     * 1-based indexing
     * @return
     */
    public int query(int p) {
        return this.arr[p] + this.queryFt(p);
    }

    private int queryFt(int p){
        int sum = 0;
        for (; p > 0; p -= p & -p) {
            sum += this.ft[p];
        }
        return sum;
    }

}
