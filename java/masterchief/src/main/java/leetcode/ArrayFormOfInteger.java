package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int curr = K;
        List<Integer> ans = new ArrayList<>();
        int i = A.length;
        while (--i >= 0 || curr > 0) {
            if (i >= 0) {
                curr += A[i];
            }
            ans.add(curr % 10);
            curr /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        ArrayFormOfInteger a = new ArrayFormOfInteger();
        List<Integer> ans = a.addToArrayForm(new int[]{0}, 0);
        String collect = ans.stream().map(i -> Integer.toString(i)).collect(Collectors.joining());
        System.out.println(collect);
    }
}
