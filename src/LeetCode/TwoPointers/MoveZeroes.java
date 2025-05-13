package src.LeetCode.TwoPointers;

import java.util.ArrayList;

// https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZero];
                nums[nonZero] = nums[i];
                nums[i] = temp;
                nonZero++;
            }
        }
    }
}
