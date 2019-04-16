package leetcode;

public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int currPos = 0;
        int farthest = currPos;
        while (currPos < nums.length - 1) {
            if (currPos + nums[currPos] >= nums.length-1) {
                return ++jumps;
            }
            int newPos = 0;
            int maxSafeJump = Integer.min(nums.length - 1, currPos + nums[currPos]);
            for (int i = currPos + 1; i <= maxSafeJump; i++) {
                if (i + nums[i] > farthest) {
                    farthest = Integer.max(farthest, i + nums[i]);
                    newPos = i;
                }
            }
            jumps++;
            currPos = newPos;
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        int ans = j.jump(new int[]{2, 3, 1, 1, 4});
//        int ans = j.jump(new int[]{3, 2, 1});
//        int ans = j.jump(new int[]{2, 3, 1});
        System.out.println(ans);
    }
}
