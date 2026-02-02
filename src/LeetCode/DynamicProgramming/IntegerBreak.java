package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/integer-break/description/?envType=problem-list-v2&envId=dynamic-programming
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        // n = i + (n-i)
        for (int num = 2; num <= n; num++) {
            for (int i = 1; i < num; i++) {
                int remain = num - i;
                int temp1 = i * remain;
                int temp2 = i * dp[remain]; // 더 잘개쪼갬 : DP 활용
                dp[num] = Math.max(dp[num], Math.max(temp1, temp2));
            }
        }

        return dp[n];
    }
}
