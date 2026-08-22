package src.LeetCode.Array;

import java.util.Arrays;

// 3107. Minimum Operations to Make Median of Array Equal to K
// https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/description/
public class MinimumOperationsToMakeMedianofArrayEqualToK {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long result = 0;

        Arrays.sort(nums);
        int mid = nums.length / 2;

        int step = (k > nums[mid]) ? 1 : -1;
        for (int i = mid; i >= 0 && i < nums.length; i += step) {
            if ((nums[i] - k) * step < 0) {
                result += Math.abs((long) nums[i] - k);
            } else {
                break;
            }
        }

        return result;
    }
}
