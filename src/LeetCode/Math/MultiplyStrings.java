package src.LeetCode.Math;

// https://leetcode.com/problems/multiply-strings/description/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n]; // 일단 최대 length 로 지정

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // '0' == 48 == charAt - '0' = 숫자
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; // 일의 자리
                int p2 = i + j + 1; // 십의 자리
                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (!(sb.isEmpty() && result[i] == 0)) {
                sb.append(result[i]);
            }
        }

        return sb.toString();
    }
}
