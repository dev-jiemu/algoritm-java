package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/maximum-subarray/?envType=problem-list-v2&envId=dynamic-programming
public class MaximumSubarray {
    // 카데인 알고리즘...? ㅇㅂㅇ?
    // Ref. https://medium.com/@vdongbin/kadanes-algorithm-%EC%B9%B4%EB%8D%B0%EC%9D%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-acbc8c279f29
    public int maxSubArray(int[] nums) {
        int current = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            max = Math.max(current, max);

            if (current < 0) {
                current = 0;
            }
        }

        return max;
    }
}
