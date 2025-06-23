package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        // 반드시 요소 1개를 삭제하고 1로 구성된 최대 문자열
        // 0이 1개 나오는것 까지 가능

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while(zeroCount > 1) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
