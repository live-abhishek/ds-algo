package dpInterview.fibonacci;

import java.util.Arrays;

public class ArrayJump {

    public int countMinJumps(int[] jumps) {
        int[] dp = new int[jumps.length];
        Arrays.fill((dp), Integer.MAX_VALUE);
        dp[0] = 0;
        for (int start = 0; start < jumps.length - 1; start++) {
            for (int end = start + 1; end < jumps.length && end <= start + jumps[start]; end++) {
                dp[end] = Integer.min(dp[end], dp[start] + 1);
            }
        }
        return dp[jumps.length - 1];
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
