package ds;

public class SegmentTree {
    int[] st;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        st = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int n, int nl, int nr) {
        if (nl == nr) {
            st[n] = arr[nl];
        } else {
            int nm = nl + (nr - nl) / 2;
            build(arr, n * 2, nl, nm);
            build(arr, n * 2 + 1, nm + 1, nr);
            st[n] = st[n * 2] + st[n * 2 + 1];
        }
    }

    public int sum(int ql, int qr) {
        return sum(1, 0, n - 1, ql, qr);
    }

    private int sum(int n, int nl, int nr, int ql, int qr) {
        if (ql > qr) {
            return 0;
        }
        if (ql == nl && qr == nr) {
            return st[n];
        }
        int nm = nl + (nr - nl) / 2;
        return sum(n * 2, nl, nm, ql, Integer.min(qr, nm))
                + sum(n * 2 + 1, nm + 1, nr, Integer.max(ql, nm + 1), qr);
    }

    public void update(int pos, int newVal) {
        update(1, 0, n - 1, pos, newVal);
    }

    private void update(int n, int nl, int nr, int pos, int newVal) {
        if (nl == nr) {
            st[n] = newVal;
        } else {
            int nm = nl + (nr - nl) / 2;
            if (pos <= nm) {
                update(n * 2, nl, nm, pos, newVal);
            } else {
                update(n * 2 + 1, nm + 1, nr, pos, newVal);
            }
            st[n] = st[n * 2] + st[n * 2 + 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 3, 7, 8, 4, 7, 1, 5, 2, 9};
        SegmentTree st = new SegmentTree(arr);
        int ans = st.sum(2, 4);
        System.out.println(ans);
        st.update(3, 5);
        ans = st.sum(2, 4);
        System.out.println(ans);
    }
}
