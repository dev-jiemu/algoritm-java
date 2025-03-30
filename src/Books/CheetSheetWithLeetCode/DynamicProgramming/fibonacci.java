package src.Books.CheetSheetWithLeetCode.DynamicProgramming;

import java.util.ArrayList;

public class fibonacci {

    // 일방적으로 알려져있는 재귀로 풀기
    public int fibonacciRecursion(int num) {
        if (num == 0) return 0;
        if (num == 1 || num == 2) return 1;

        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }

    // 중복 계산 제외
    public int fibonacciNotDuplicate(int num) {
        if (num == 0) return 0;
        ArrayList<Integer> memo = new ArrayList<>();

        for (int i = 0; i <= num; i++) {
            memo.add(0);
        }

        return helper(memo, num);
    }

    private int helper(ArrayList<Integer> memo, int num) {
        if (num == 1 || num == 2) return 1;
        if (memo.get(num) != 0) return memo.get(num);

        memo.set(num, helper(memo, num - 1) + helper(memo, num - 2));

        return memo.get(num);
    }

    // DP 배열
    public int fibonacciDP(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }
}
