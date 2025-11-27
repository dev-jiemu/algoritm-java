package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/rotate-function/?envType=problem-list-v2&envId=dynamic-programming
public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        // F(k+1) = F(k) + sum - n * nums[n-k-1]
        int[] dp = new int[nums.length];
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // dp[0] 구하기
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[0] += i * nums[i];
        }

        // dp[1] 부터 나머지 구하기
        for (int k = 1; k < n; k++) {
            dp[k] = dp[k-1] + sum - n * nums[n-k];
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
