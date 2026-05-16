package src.LeetCode.Array;

import java.util.Arrays;

// 3467. Transform Array by Parity
// https://leetcode.com/problems/transform-array-by-parity/description/
public class TransformArrayByParity {
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }

        // 정렬
        Arrays.sort(nums);

        return nums;
    }
}
