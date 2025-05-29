package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] dp = new int[38]; // 0 <= n <= 37
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
