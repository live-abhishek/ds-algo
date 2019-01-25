package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int state = convertToNum(cells);
        Map<Integer, Integer> map = new HashMap<>();
        while (N > 0) {
            if (map.containsKey(state)) {
                N %= map.get(state) - N;
            }
            map.put(state, N);
            if (N >= 1) {
                N--;
                state = getNextNum(state);
            }
        }
        return convertToArray(state);
    }

    public int convertToNum(int[] cells){
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            ans = ans << 1;
            if (cells[i] == 1) {
                ans = ans | 1 ;
            }
        }
        return ans;
    }

    public int getNextNum(int num) {
        int ans = 0;
        for (int i = 1; i < 7; i++) {
            boolean left = (num & (1 << i+1)) != 0;
            boolean right = (num & (1 << i-1)) != 0;
            // if both cells are in same state
            if (left == right) {
                ans = ans | (1 << i); // then turn the bit on
            } else {
                ans = ans & ~(1 << i); // else turn off that bit
            }
        }
        return ans;
    }

    public int[] convertToArray(int num){
        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            int val = num & (1 << i);
            ans[8 - i - 1] = (val != 0) ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        PrisonAfterNDays p = new PrisonAfterNDays();
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int[] ans = p.prisonAfterNDays(cells, 1000000000);
        System.out.println(Arrays.stream(ans).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]")));
    }
}
