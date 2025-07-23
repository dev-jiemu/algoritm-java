package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, n, k, 1, new ArrayList<>());
        return result;
    }

    // 1부터 n까지, k개의 쌍을 이루는 조합
    private void backtrack(List<List<Integer>> result, int n, int k, int start, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, n, k, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
