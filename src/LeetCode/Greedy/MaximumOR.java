package src.LeetCode.Greedy;

// https://leetcode.com/problems/maximum-or/description/
// prefix, suffix pattern : 하나 빼고 나머지 계산할때
public class MaximumOR {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        long[] suffix = new long[n + 1];

        // prefix OR 계산
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] | nums[i];
        }

        // suffix OR 계산
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] | nums[i];
        }

        long max = 0;

        for (int i = 0; i < n; i++) {
            long shifted = (long)nums[i] << k;
            long result = prefix[i] | shifted | suffix[i + 1];
            max = Math.max(max, result);
        }

        return max;
    }
}
