package src.LeetCode.Math;

// https://leetcode.com/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}
