package src.LeetCode.Math;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        long result = 0;

        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        x = Math.abs(x);

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        if (result > Integer.MAX_VALUE) { // 오버플로우 체크
            return 0;
        }

        return isNegative ? -(int)result : (int)result;
    }
}
