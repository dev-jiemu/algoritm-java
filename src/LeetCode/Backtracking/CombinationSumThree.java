package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
public class CombinationSumThree {
    // k : 몇개의 조합, n : target
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, new ArrayList<>(), 1, result);

        return result;
    }

    private void backtrack(int k, int n, List<Integer> current, int start, List<List<Integer>> list) {
        if (current.size() == k) {
            if (n == 0) {
                list.add(new ArrayList<>(current));
                return;
            }
        }

        if (n < 0) {
            return; // 존재불가
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(k, n - i, current, i + 1, list);
            current.remove(current.size() - 1);
        }
    }
}
