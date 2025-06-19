package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/
public class MaximumAbsoluteSumofAnySubarray {
    // 카데인 알고리즘 practice
    // 절대값이니까 음수에 대한 계산도 해야하는거...
    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int current = 0;

        // max
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];

            if (current < 0) {
                current = 0;
            }

            max = Math.max(max, current);
        }

        current = 0;
        for (int j = 0; j < nums.length; j++) {
            current += nums[j];

            if (current > 0) {
                current = 0;
            }

            min = Math.min(min, current);
        }

        return Math.max(-min, max);
    }
}
