package leetcode;

import java.util.HashSet;

public class UglyNumbers2 {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        int indexWithWhich2WillMul = 0;
        int indexWithWhich3WillMul = 0;
        int indexWittWhich5WillMul = 0;
        for (int i = 1; i < n; i++) {
            int t2 = 2*ans[indexWithWhich2WillMul];
            int t3 = 3*ans[indexWithWhich3WillMul];
            int t5 = 5*ans[indexWittWhich5WillMul];
            int tempAns = -1;
            if (t2 <= t3 && t2 <= t5) {
                indexWithWhich2WillMul++;
                tempAns = t2;
            } else if (t3 <= t2 && t3 <= t5) {
                indexWithWhich3WillMul++;
                tempAns = t3;
            } else if(t5 <= t2 && t5 <= t3) {
                indexWittWhich5WillMul++;
                tempAns = t5;
            }
            if (set.contains(tempAns)) {
                i--;
            } else {
                set.add(tempAns);
                ans[i] = tempAns;
            }
        }
        return ans[ans.length-1];
    }

    public static void main(String[] args) {
        UglyNumbers2 un = new UglyNumbers2();
        int ans = un.nthUglyNumber(10);
        System.out.println(ans);
    }
}
