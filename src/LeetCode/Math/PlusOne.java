package src.LeetCode.Math;

// https://leetcode.com/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;

            if (digits[i] != 10) {
                return digits;
            }

            digits[i] = 0;
        }

        // 모든 자리수가 9인 경우도 있을수 있음
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
