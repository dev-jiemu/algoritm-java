package src.LeetCode.TwoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/?envType=problem-list-v2&envId=sorting
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 일단 정렬하고 시작
        Arrays.sort(nums);

        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }

                // 찾음
                if (currentSum == target) {
                    return currentSum;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
