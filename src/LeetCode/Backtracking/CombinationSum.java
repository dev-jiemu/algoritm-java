package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    // 모든 조합 다 찾아야함 : 백트래킹
    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 존재할 수 없는 조합 ㅇ_ㅇ
        if (remain < 0) { return; }

        for(int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);

            backtrack(candidates, remain - candidates[i], i, current, result);

            // 백트래킹 처리
            current.remove(current.size() - 1);
        }
    }
}
