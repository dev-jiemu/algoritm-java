package src.LeetCode.Bits;

// 342. Power of Four
// https://leetcode.com/problems/power-of-four/description/
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        // 2의 거듭제곱인지 확인
        boolean isPowerOfTwo = (n & (n - 1)) == 0;

        return isPowerOfTwo && (n - 1) % 3 == 0;
    }
}
