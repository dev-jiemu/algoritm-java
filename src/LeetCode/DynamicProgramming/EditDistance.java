package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j] -- 삭제
                    // dp[i][j - 1] -- 삽입
                    // dp[i - 1][j - 1] -- 교체

                    // (삭제/삽입 min) 교체 max
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
