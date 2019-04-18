package leetcode;

public class SqrtXOther {
    public int mySqrt(int x) {
        int l = 1, h = Integer.MAX_VALUE;
        int ans = 0;
        // upper bound
        // returns element which is 1 greater than searched value
        while (l < h) {
            int m = l + (h - l) / 2;
            if (x / m <= m) {
                ans = m;
                h = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int mySqrtNewton(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
