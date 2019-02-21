package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<int[]> stk = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            int num = T[i];
            while (!stk.isEmpty() && stk.peek()[0] <= num) {
                stk.pop();
            }
            if(stk.isEmpty()){
                res[i] = 0;
                stk.push(new int[]{num, i});
            } else {
                res[i] = stk.peek()[1] - i;
                stk.push(new int[]{num, i});
            }
        }
        return res;
    }
}
