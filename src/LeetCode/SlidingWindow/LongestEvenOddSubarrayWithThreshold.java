package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/
public class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;

        for (int start = 0; start < nums.length; start++) {
            if (nums[start] % 2 == 0 && nums[start] <= threshold) {
                int end = start;

                // nums[end] % 2 != nums[end + 1] % 2 = 패리티 체크
                // nums[end] % 2 == 0
                // nums[end + 1] % 2 == 1
                // 둘이 같으면 둘다 짝수이거나 둘다 홀수이니까 이렇게도 체크 가능함
                while(end + 1 < nums.length && nums[end + 1] <= threshold && nums[end] % 2 != nums[end + 1] % 2) {
                    end++;
                }

                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}
