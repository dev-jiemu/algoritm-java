package src.LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

// 3026. Maximum Good Subarray Sum
// https://leetcode.com/problems/maximum-good-subarray-sum/description/
public class MaximumGoodSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0; // prefix
        Map<Integer, Long> minPrefix = new HashMap<>();
        long result = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            long end = sum + nums[i];

            if (minPrefix.containsKey(nums[i] + k)) {
                result = Math.max(result, end - minPrefix.get(nums[i] + k));
            }
            if (minPrefix.containsKey(nums[i] - k)) {
                result = Math.max(result, end - minPrefix.get(nums[i] - k));
            }

            minPrefix.merge(nums[i], sum, Math::min);

            sum = end;
        }

        return result == Long.MIN_VALUE ? 0 : result;
    }
}
