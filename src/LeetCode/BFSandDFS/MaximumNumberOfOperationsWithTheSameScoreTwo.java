package src.LeetCode.BFSandDFS;

import java.util.HashMap;
import java.util.Map;

// 3040. Maximum Number of Operations With the Same Score II
// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/description/
public class MaximumNumberOfOperationsWithTheSameScoreTwo {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int result = 0;

        // 앞에 두개 삭제했을때
        result = Math.max(result, 1 + dfs(nums, 2, n-1, nums[0] + nums[1], new HashMap<>()));

        // 뒤에 두개 삭제했을때
        result = Math.max(result, 1 + dfs(nums, 0, n-3, nums[n-2] + nums[n-1], new HashMap<>()));

        // 앞 뒤로 하나씩 삭제했을때
        result = Math.max(result, 1 + dfs(nums, 1, n-2, nums[0] + nums[n-1], new HashMap<>()));

        return result;
    }

    private int dfs(int[] nums, int left, int right, int target, Map<Integer, Integer> memo) {
        if (left >= right) {
            return 0;
        }

        int key = left * 10000 + right;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;

        // 앞에 두개
        if (left + 1 <= right && nums[left] + nums[left + 1] == target) {
            result = Math.max(result, 1 + dfs(nums, left + 2, right, target, memo));
        }

        // 뒤에 두개
        if (left <= right - 1 && nums[right - 1] + nums[right] == target) {
            result = Math.max(result, 1 + dfs(nums, left, right - 2, target, memo));
        }

        // 양쪽으로
        if (nums[left] + nums[right] == target) {
            result = Math.max(result, 1 + dfs(nums, left + 1, right - 1, target, memo));
        }

        memo.put(key, result);
        return result;
    }
}
