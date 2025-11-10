package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/?envType=problem-list-v2&envId=backtracking
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // 자바에서 List add 할때 reference 가 발생함을 응용
        backtracking(nums, 0, current, result);

        return result;
    }

    private void backtracking(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
