package src.LeetCode.DynamicProgramming;

// 1668. Maximum Repeating Substring
// https://leetcode.com/problems/maximum-repeating-substring/description/
public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];

        int answer = 0;

        for (int i = n - m; i >= 0; i--) {
            // sequence.substring(i, i + m).equals(word)
            if (sequence.regionMatches(i, word, 0, m)) {
                dp[i] = dp[i + m] + 1;
                answer = Math.max(answer, dp[i]);
            }
        }

        return answer;
    }
}
