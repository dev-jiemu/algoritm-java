package src.LeetCode.PrefixSum;

// 848. Shifting Letters
// https://leetcode.com/problems/shifting-letters/description/
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int sum = 0; // prefix sum
        for (int i = n - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            arr[i] = (char) ((arr[i] - 'a' + sum) % 26 + 'a'); // z -> a 순환 변환
        }

        return new String(arr);
    }
}
