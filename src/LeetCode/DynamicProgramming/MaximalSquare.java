package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/maximal-square/?envType=problem-list-v2&envId=dynamic-programming
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // dp[i][j] = (i, j) 위치를 오른쪽 아래 꼭지점으로 하는 가장 큰 정사각형의 한변의 길이
        // 위쪽, 왼쪽, 대각선 왼쪽 위
        // dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide; // 정사각형
    }
}
