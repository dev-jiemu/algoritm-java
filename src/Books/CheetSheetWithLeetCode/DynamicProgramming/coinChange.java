package src.Books.CheetSheetWithLeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class coinChange {

    // 1. 무차별 재귀로 풀기
    public int coinChangeRecursion(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subproblem = dp(coins, amount - coins[i]);

            if (subproblem == -1) continue;

            result = Math.min(result, 1 + subproblem);
        }

        return result;
    }

    // 2. 메모이제이션
    public int coinChangeMemoization(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(coins, amount, memo);
    }

    private int dp(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo.containsKey(amount)) return memo.get(amount);

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subproblem = dp(coins, amount - coin, memo);
            if (subproblem == -1) continue;
            result = Math.min(result, 1 + subproblem);
        }

        memo.put(amount, (result == Integer.MAX_VALUE) ? -1 : result);
        return memo.get(amount);
    }

    // 3. dp 배열에서 상태를 가질때 (bottom-up DP)
    public int coinChangeBottomUpDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 불가능한 큰 값으로 초기화
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
