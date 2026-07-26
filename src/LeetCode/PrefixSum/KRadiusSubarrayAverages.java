package src.LeetCode.PrefixSum;

import java.util.Arrays;

// 2090. K Radius Subarray Averages
// https://leetcode.com/problems/k-radius-subarray-averages/description/
public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int[] output = new int[nums.length];
        Arrays.fill(output, -1);

        for (int i = k; i < nums.length - k; i++) {
            long sum = (i - k - 1 >= 0) ? prefix[i+k] - prefix[i-k-1] : prefix[i+k];
            output[i] = (int) (sum / (2 * k + 1));
        }

        return output;
    }
}
