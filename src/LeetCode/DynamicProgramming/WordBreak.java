package src.LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 빈 문자열은 일단 가능으로 침

        for (int i = 0; i <= s.length(); i++) {
            for  (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}