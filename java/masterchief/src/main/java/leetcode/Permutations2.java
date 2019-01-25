package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        List<Integer> listNums = new ArrayList<>();
        for(int i : nums) listNums.add(i);

        permute(listNums, 0, permutations);
        return permutations;
    }

    private void permute(List<Integer> nums, int start, List<List<Integer>> list){
        if (start == nums.size()) {
            list.add(new ArrayList<>(nums));
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.size(); i++) {
            if(!visited.contains(nums.get(i))) {
                visited.add(nums.get(i));
                Collections.swap(nums, start, i);
                permute(nums, start + 1, list);
                Collections.swap(nums, start, i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permuter = new Permutations();
        List<List<Integer>> permutations = permuter.permute(new int[]{1, 2, 4, 3, 4});
        permutations.forEach(p -> System.out.println(p.stream().map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"))));
    }
}
