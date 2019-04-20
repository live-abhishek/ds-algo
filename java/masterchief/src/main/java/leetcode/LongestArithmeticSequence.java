package leetcode;

import java.util.HashMap;
import java.util.Map;

// TODO
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = A[i] = A[j];
            }
        }
        return 0;
    }

    private int getLargestLen(int[] A, int pos, int d) {
        int maxLen = 0;
        int num = A[pos];
        for (int i = pos - 1; i >= 0; i--) {
            int currNum = A[i];
            if ((num - currNum) == d) {
                int currLen = getLargestLen(A, i, d);
                maxLen = Integer.max(maxLen, currLen);
            } else {
                continue;
            }
        }
        return maxLen;
    }
}
