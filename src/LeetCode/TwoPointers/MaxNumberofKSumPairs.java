package src.LeetCode.TwoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int result = 0;

        int left = 0;
        int right = nums.length - 1;

        // nums 배열 정렬
        Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] == k) {
                result++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
