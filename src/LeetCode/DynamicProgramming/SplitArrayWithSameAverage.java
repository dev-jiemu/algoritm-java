package src.LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/split-array-with-same-average/description/
public class SplitArrayWithSameAverage {
    // 두 부분집합의 평균이 같으려면 전체 배열의 평균도 같아야 함
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length < 2) return false;

        Set<Integer>[] dp = new HashSet[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);


        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int num : nums) {
            for (int i = nums.length - 1; i >= 0; i--) {
                for(int sum : dp[i]) {
                    dp[i + 1].add(sum + num);
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for(int sum : dp[i]) {
                if (sum * nums.length == totalSum * i) {
                    return true; // 하나라도 만족하면 끝
                }
            }
        }

        return false;
    }
}
