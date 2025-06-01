package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
public class UniquePaths {
    // 오른쪽 또는 아래로만 움직일 수 있음
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 맨 왼쪽 위에서 시작한다고 했으므로 0,0 은 1로 fix
        dp[0][0] = 1;

        // 가장자리 배열 1로 초기화
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
