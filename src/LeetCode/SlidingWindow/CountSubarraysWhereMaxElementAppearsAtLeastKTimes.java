package src.LeetCode.SlidingWindow;

// 2962. Count Subarrays Where Max Element Appears at Least K Times
// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int left = 0;
        int count = 0;
        long result = 0;

        for(int right = 0; right < nums.length; right++) {
            if (nums[right] == maxNum) {
                count++;
            }

            while (count >= k) {
                result += (nums.length - right); // left 부터 시작하는 모든 subarray 가 전부 유효함

                if(nums[left] == maxNum) {
                    count--;
                }
                left++;
            }
        }

        return result;
    }
}
