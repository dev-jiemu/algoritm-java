package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int current = 0;
        int length = Integer.MAX_VALUE;

        // 왼쪽서부터 접근
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];

            while (current >= target) {
                length = Math.min(length, right - left + 1);
                current -= nums[left];
                left += 1;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
