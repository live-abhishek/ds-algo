package leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            // skip whose previous number exist in set
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                while (set.contains(++num)) {
                    currentStreak++;
                }
                longestStreak = Integer.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
