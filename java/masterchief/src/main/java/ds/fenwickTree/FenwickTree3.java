package ds.fenwickTree;

// TODO
public class FenwickTree3 {
    private int[] ft1;
    private int[] ft2;

    public FenwickTree3(int[] arr, int size) {
        this.ft1 = new int[size + 1];
        this.ft2 = new int[size + 1];
        for (int i = 1; i < size+1; i++) {
            update(this.ft1, i, arr[i - 1]);
            update(this.ft2, i, arr[i - 1]);
        }
    }

    /**
     * Updates the Fenwick tree
     * @param p position of the element. 1-based indexing
     * @param v
     */
    private void update(int[] ft, int p, int v) {
        for (; p < ft.length; p += p & -p) {
            ft[p] += v;
        }
    }

    /**
     * Updates given range. 1-based indexing
     * @param l
     * @param r
     * @param v
     */
    public void rangeUpdate(int l, int r, int v) {
        update(this.ft1, l, v);
        update(this.ft1, r + 1, -v);
        update(this.ft2, l, v * (l - 1));
        update(this.ft2, r + 1, -v * r);
    }

    /**
     *
     * @param p 1-based indexing
     * @return
     */
    private int prefixSumHelper(int[] ft, int p){
        int sum = 0;
        for (; p > 0; p -= p & -p) {
            sum += ft[p];
        }
        return sum;
    }

    /**
     *
     * @param p 1-based indexing
     * @return
     */
    private int prefixSum(int p) {
        int leftSum = prefixSumHelper(this.ft1, p) * p;
        int rightSum = prefixSumHelper(this.ft2, p);
        return leftSum - rightSum;
    }

    /**
     * 1-based indexing
     * @param l
     * @param r
     * @return
     */
    public int rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l);
    }

    public static void main(String[] args) {
        FenwickTree3 ft = new FenwickTree3(new int[]{0, 0, 0, 0, 0}, 5);
        ft.rangeUpdate(1, 5, 5);
        ft.rangeUpdate(3, 5, 10);
        int sum = ft.rangeSum(2, 5);
        System.out.println(sum);
    }
}
