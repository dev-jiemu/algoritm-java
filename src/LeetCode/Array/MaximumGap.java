package src.LeetCode.Array;

import java.util.Arrays;

// 164. Maximum Gap
// https://leetcode.com/problems/maximum-gap/description/
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int result = 0;

        if (nums.length < 2) {
            return result;
        }

        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }

        return result;
    }
}
