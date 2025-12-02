package src.LeetCode.Bits;

// https://leetcode.com/problems/divide-two-integers/description/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // divisor 를 n^2 해서 키워나가면?
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 둘중 하나 음수?
        boolean negative = (divisor < 0) ^ (dividend < 0);

        // 오버플로우 방지 + 절대값
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long result = 0;

        while(ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;

            // ldvidend 에 가장 가까운 multiple 구하기
            while(ldividend >= (temp << 1)) {
                temp <<= 1; // temp = temp * 2
                multiple <<= 1; // multiple = multiple * 2
            }

            ldividend -= temp;
            result += multiple;
        }

        return negative ? (int)-result : (int)result;
    }
}
