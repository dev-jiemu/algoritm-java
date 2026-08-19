package src.LeetCode.DynamicProgramming;

// 2370. Longest Ideal Subsequence
// https://leetcode.com/problems/longest-ideal-subsequence/description/
public class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int result = 0;

        int[] dp = new int[26]; // 소문자 알파벳 26개
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            int lo = Math.max(0, idx - k);
            int hi = Math.min(25, idx + k);
            int best = 0;
            for (int j = lo; j <= hi; j++) {
                best = Math.max(best, dp[j]);
            }
            dp[idx] = best + 1;
            result = Math.max(result, dp[idx]);
        }

        return result;
    }
}
