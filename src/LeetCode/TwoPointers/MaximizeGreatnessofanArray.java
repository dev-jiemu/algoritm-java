package src.LeetCode.TwoPointers;

import java.util.Arrays;

// 2592. Maximize Greatness of an Array
// https://leetcode.com/problems/maximize-greatness-of-an-array/
public class MaximizeGreatnessofanArray {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if (nums[left] < nums[right]) {
                left++;
            }
        }

        return left;
    }
}
