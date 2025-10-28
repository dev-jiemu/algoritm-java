package src.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/?envType=problem-list-v2&envId=dynamic-programming
public class LargestDivisibleSubset {
    /*
        점화식
        if (nums[i] % nums[j] == 0):
           dp[i] = max(dp[i], dp[j] + 1)
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        // 정렬먼저
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n]; // 경로 추적용
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[i]가 nums[j]로 나누어떨어지면
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j; // 이전 인덱스 저장
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        return result;
    }
}
