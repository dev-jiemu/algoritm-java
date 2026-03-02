package src.LeetCode.Math;

import java.util.Arrays;

// https://leetcode.com/problems/split-with-minimum-sum/
public class SplitWithMinimumSum {
    public int splitNum(int num) {
        // 최소화
        // 정렬 한번 하기

        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);

        int num1 = 0;
        int num2 = 0;

        // 작은 숫자일수록 높은 자리에 안오도록 나눠담기
        for (int i = 0; i < digits.length; i++) {
            int d = digits[i] - '0';
            if (i % 2 == 0) {
                num1 = num1 * 10 + d;
            } else {
                num2 = num2 * 10 + d;
            }
        }

        return num1 + num2;
    }
}
