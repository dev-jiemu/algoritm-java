package src.LeetCode.Recursion;

// https://leetcode.com/problems/power-of-two/description/?envType=problem-list-v2&envId=recursion
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        return recursion(n, 1);
    }

    private boolean recursion(int n, int curr) {
        if (n == curr) {
            return true;
        }

        if (curr > n / 2) {
            return false;
        }

        return recursion(n, curr * 2);
    }
}
