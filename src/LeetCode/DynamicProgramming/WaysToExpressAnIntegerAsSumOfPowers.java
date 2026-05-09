package src.LeetCode.DynamicProgramming;

import java.util.Arrays;

// 2787. Ways to Express an Integer as Sum of Powers
// https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
public class WaysToExpressAnIntegerAsSumOfPowers {
    // Since the result can be very large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    // DP + 메모이제이션
    public int numberOfWays(int n, int x) {
        // i^x <= n
        // 제곱으로 n 에 근접한 숫자 까지를 범위로 잡으면 될듯
        int maxI = (int) Math.pow(n, 1.0/x) + 1;
        int[][] dp = new int[n + 1][maxI + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, 1, x, dp, maxI);
    }

    private int solve(int remaining, int current, int x, int[][] dp, int maxI) {
        if (remaining == 0) return 1;
        if (current > maxI) return 0; // 범위 초과

        int power = (int) Math.pow(current, x);
        if (power > remaining) {
            return 0; // 불가능
        }

        // 메모이제이션 체크
        if (dp[remaining][current] != -1) {
            return dp[remaining][current];
        }

        // 두 가지 경우 모두 시도해야함
        int include = solve(remaining - power, current + 1, x, dp, maxI); // 포함
        int exclude = solve(remaining, current + 1, x, dp, maxI); // 불포함

        dp[remaining][current] = (include + exclude) % MOD;
        return dp[remaining][current];
    }
}
