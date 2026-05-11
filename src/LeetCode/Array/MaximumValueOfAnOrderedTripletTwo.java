package src.LeetCode.Array;

// 2874. Maximum Value of an Ordered Triplet II
// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/
public class MaximumValueOfAnOrderedTripletTwo {
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        int maxI = nums[0];
        int maxDiff = 0; // nums[i] - nums[j] 최대값

        for(int k = 1; k < nums.length; k++) {
            if (k >= 2) {
                result = Math.max(result, (long) maxDiff * nums[k]); // 최대값만 찾으면 됨
            }

            maxDiff = Math.max(maxDiff, maxI - nums[k]);
            maxI = Math.max(maxI, nums[k]);
        }


        return result;
    }
}
