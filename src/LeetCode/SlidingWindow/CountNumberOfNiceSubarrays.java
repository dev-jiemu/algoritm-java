package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/count-number-of-nice-subarrays/?envType=problem-list-v2&envId=sliding-window
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) { // 홀수를 만나면 카운트 증가
                count++;
            }

            while (count > k) {
                if (nums[left] % 2 == 1) {
                    count--;
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
