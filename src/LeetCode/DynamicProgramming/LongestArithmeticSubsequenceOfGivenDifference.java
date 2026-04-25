package src.LeetCode.DynamicProgramming;

import java.util.HashMap;

// 1218. Longest Arithmetic Subsequence of Given Difference
// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        // 인덱스가 아니라 value 기준으로 DP를 해야하니까 hashmap 활용
        HashMap<Integer, Integer> hash = new HashMap<>();
        int maxLength = 1;

        for(int num : arr) {
            int prevNum = num - difference;

            int currentLength = hash.getOrDefault(prevNum, 0) + 1;

            hash.put(num, currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
