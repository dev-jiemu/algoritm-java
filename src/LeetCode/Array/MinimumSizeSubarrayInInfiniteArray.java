package src.LeetCode.Array;

// https://leetcode.com/problems/minimum-size-subarray-in-infinite-array/
public class MinimumSizeSubarrayInInfiniteArray {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;

        // target = (배열 전체합) × q + r
        // q = 몫 = 배열 전체를 포함하는 횟수
        // r = 나머지 = 나머지 합 만큼 필요함
        long total = 0;
        for (int x : nums) {
            total += x;
        }

        int q = (int)(target / total);
        int r = (int)(target % total);

        if (r == 0) {
            return q * n;
        }

        int minLen = Integer.MAX_VALUE;
        long windowSum = 0;
        int left = 0;

        // r 범위만 찾을거니까 2n 으로만 한정함
        for (int right = 0; right < 2 * n; right++) {
            windowSum += nums[right % n];
            while(windowSum > r) {
                windowSum -= nums[left % n];
                left++;
            }

            if (windowSum == r) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : q * n + minLen;
    }
}
