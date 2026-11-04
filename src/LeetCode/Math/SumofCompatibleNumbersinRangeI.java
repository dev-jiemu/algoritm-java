package src.LeetCode.Math;

// 3954. Sum of Compatible Numbers in Range I
// https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/description/
public class SumofCompatibleNumbersinRangeI {
    // Constraints:
    // 1 <= n <= 100
    // 1 <= k <= 100
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;

        // |n - x| <= k
        // = n - k <= x <= n + k
        for (int x = Math.max(1, n - k); x <= n + k; x++) {
            if ((n & x) == 0) {
                sum += x;
            }
        }

        return sum;
    }
}
