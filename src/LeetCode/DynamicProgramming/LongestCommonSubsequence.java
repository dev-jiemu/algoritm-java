package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/longest-common-subsequence/?envType=study-plan-v2&envId=leetcode-75
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char one = text1.charAt(i - 1);
                char two = text2.charAt(j - 1);
                if (one == two) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

/*
if (조건이 같을 때) {
    dp[i][j] = dp[i-1][j-1] + 1;  // 대각선 + 1
} else {
    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  // 위쪽, 왼쪽 중 최대
}

ex)
- 두 문자열을 같게 만드는 최소 연산 수
- 연속된 공통 부분 문자열
- 희문 부분 수열
 */