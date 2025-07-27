package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtracking(nums, result, current, used);

        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;

            backtracking(nums, result, current, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
