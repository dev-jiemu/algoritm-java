package src.LeetCode.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/extra-characters-in-a-string/
public class ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        // substring 을 체크해야 하는거라서 단순 hash 만으로는 안풀리는군 ㅇㅂㅇ...
        int n = s.length();
        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dictSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}
