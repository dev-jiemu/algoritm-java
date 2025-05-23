package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0;

        for (int i = 0; i < k; i++) {
            result += nums[i];
        }

        double current = result;
        for (int i = k; i < nums.length; i++) {
            current = current - nums[i - k] + nums[i];
            result = Math.max(result, current);
        }

        return result / k;
    }
}
