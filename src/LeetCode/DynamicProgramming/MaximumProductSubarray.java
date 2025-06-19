package src.LeetCode.DynamicProgramming;

public class MaximumProductSubarray {
    // https://leetcode.com/problems/maximum-product-subarray/
    // 카데인 알고리즘 practice
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int minCurrent = nums[0];
        int maxCurrent = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int temp = maxCurrent;

            maxCurrent = Math.max(Math.max(num * maxCurrent, num * minCurrent), num);
            minCurrent = Math.min(Math.min(num * temp, num * minCurrent), num);

            result = Math.max(result, maxCurrent);
        }

        return result;
    }
}
