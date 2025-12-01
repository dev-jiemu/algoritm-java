package src.LeetCode.String;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToInteger {
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;

        // 공백 있으면 건너뛰기
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length()) {
            char c = s.charAt(i);

            // 숫자가 아니면 중단
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // 오버플로우 체크
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
