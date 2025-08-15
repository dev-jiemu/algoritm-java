package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/minimum-path-sum/submissions/1736123640/?envType=study-plan-v2&envId=top-interview-150
public class MinimumPathSum {
    // 2 DP
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 오른쪽으로만 이동함
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 아래쪽으로만 이동함
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 위 또는 왼쪽꺼 중 작은거 선택함
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1]; // 오른쪽 아래 모서리가 답
    }
}
