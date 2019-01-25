package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        List<Integer> listNums = new ArrayList<>();
        for(int i : nums) listNums.add(i);

        permute(listNums, 0, permutations);
        return permutations;
    }

    private void permute(List<Integer> nums, int start, List<List<Integer>> list){
        if (start == nums.size()) {
            list.add(new ArrayList<>(nums));
        }
        for (int i = start; i < nums.size(); i++) {
            // swap nums[i] with nums[start]
            Collections.swap(nums, start, i);
            permute(nums, start+1, list);
            Collections.swap(nums, start, i);
        }
    }

    public static void main(String[] args) {
        Permutations permuter = new Permutations();
        List<List<Integer>> permutations = permuter.permute(new int[]{1, 2, 3, 4});
        permutations.forEach(p -> System.out.println(p.stream().map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"))));
    }
}
