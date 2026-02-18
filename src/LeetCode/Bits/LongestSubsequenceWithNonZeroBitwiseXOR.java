package src.LeetCode.Bits;

// https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
public class LongestSubsequenceWithNonZeroBitwiseXOR {
    // XOR 값이 0이 아닌 가장 긴 부분 수열(subsequence)을 찾아야함
    public int longestSubsequence(int[] nums) {
        // 전체 배열의 XOR 값이 0이 아니면 = 배열 전체가 답
        // 만약 0이면 원소 하나 빼야함 == nums.length - 1

        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        if (xor != 0) {
            return nums.length;
        }

        for(int n : nums) {
            if (n != 0) {
                return nums.length - 1;
            }
        }

        return 0;
    }
}
