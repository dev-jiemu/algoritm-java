package src.LeetCode.Math;

// 3790. Smallest All-Ones Multiple
// https://leetcode.com/problems/smallest-all-ones-multiple/
public class SmallestAllOnesMultiple {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int remainder = 0;
        for(int i = 1; i <= k; i++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return i;
            }
        }

        return -1;
    }
}
