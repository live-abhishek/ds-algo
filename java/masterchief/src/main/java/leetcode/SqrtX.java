package leetcode;

public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long l = 1, r = x;
        while(l < r){
            long m = l + (r-l) / 2;
            if (x / m < m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (int)l-1;
    }

    public static void main(String[] args) {
        SqrtX s = new SqrtX();
        // 2147395599
        // 2147483647
        int i = s.mySqrt(1);
        System.out.println(i);
    }
}
