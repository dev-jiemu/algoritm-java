package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/01-matrix/?envType=problem-list-v2&envId=dynamic-programming
public class OneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        // 2-pass dp
        // 왼쪽 -> 오른쪽, 위 -> 아래
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE - 10000; // overflow 방지
                    if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1); // 위
                    if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1); // 왼쪽
                }
            }
        }

        // 오른쪽 -> 왼쪽, 아래 -> 위
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1); // 아래
                if (j < n - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1); // 오른쪽
            }
        }

        return dp;
    }
}
