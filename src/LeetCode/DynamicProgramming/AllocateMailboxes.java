package src.LeetCode.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/allocate-mailboxes/description/
public class AllocateMailboxes {
    // 절댓값 거리의 합을 최소화할 때 = 중앙값
    /*
        1. 구간에 대해 하나의 우체통으로 퉁칠때 최소 비용 파악
        2. dp[i][j] = min(dp[p][j-1] + cost[p+1][i]) for all valid p
           cost[p+1][i] = (p+1)번째부터 i번째 집까지 하나의 우체통으로 커버 가능한 비용
    */
    public int minDistance(int[] houses, int k) {
        // 일단 정렬
        Arrays.sort(houses);

        int n = houses.length;
        int[][] cost = new int[n][n];

        // cost 계산
        for(int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int medianIdx = (i  + j ) / 2;
                int medianPos = houses[medianIdx];
                for(int p = i; p <= j; p++) {
                    cost[i][j] += Math.abs(houses[p] - medianPos);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];

        // dp 배열 초기화 (큰 값으로)
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);  // 오버플로우 방지 ㅇㅂㅇ...
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                // p = 처음 p개의 집을 j-1개의 우체통으로 커버
                // 최소값 : j-i (j-1개 우체통으로 커버)
                // 최대값 : i-1 (전체 i개집 중에 최소 1개는 마지막 우체통이)
                for(int p = j - 1; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[p][j-1] + cost[p][i-1]);
                }
            }
        }

        return dp[n][k];
    }
}
