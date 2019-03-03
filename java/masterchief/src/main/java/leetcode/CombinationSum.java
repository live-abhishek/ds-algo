package leetcode;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    public void helper(int[] candidates, int target, List<Integer> currList, List<List<Integer>> resList, int start) {
        if (target < 0) {
        } else if (target == 0) {
            resList.add(new ArrayList<>(currList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                currList.add(num);
                helper(candidates, target - num, currList, resList, i);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
