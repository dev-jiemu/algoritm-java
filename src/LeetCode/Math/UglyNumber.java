package src.LeetCode.Math;

// 263. Ugly Number
// https://leetcode.com/problems/ugly-number/description/
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) { // 혹시 음수가 있을수도
            return false;
        }

        // 2로 나눔
        while(n % 2 == 0) {
            n /= 2;
        }

        // 3으로 나눔
        while(n % 3 == 0) {
            n /= 3;
        }

        // 5로 나눔
        while(n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
