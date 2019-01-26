package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 0;
        List<Integer> squares = getSquares(n);
        for (Integer sq : squares) {
            counts[sq] = 1;
        }
        if(counts[n] == 1) return 1;
        LinkedList<Integer> queue = new LinkedList<>(squares);
        while (!queue.isEmpty()) {
            Integer num = queue.removeFirst();
            for (Integer square : squares) {
                int newNum = num + square;
                if (newNum > n) {
                    break;
                } else {
                    if (counts[newNum] == 0) {
                        counts[newNum] = counts[num] + 1;
                    }
                    if (newNum == n) {
                        return counts[newNum];
                    }
                    queue.addLast(newNum);
                }
            }
        }
        return counts[n];
    }
    private List<Integer> getSquares (int n){
        List<Integer> squares = new ArrayList<>();
        int i = 1;
        while (i*i <= n) {
            squares.add(i*i);
            i++;
        }
        return squares;
    }
}
