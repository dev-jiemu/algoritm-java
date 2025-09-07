package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for(int num : nums) {
            int pos = binarySearch(tails, size, num);
            tails[pos] = num;
            if (pos == size) {
                size++;
            }
        }

        return size;
    }

    private int binarySearch(int[] tails, int size, int num) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
