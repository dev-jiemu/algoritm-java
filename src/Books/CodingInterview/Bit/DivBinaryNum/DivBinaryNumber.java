package src.Books.CodingInterview.Bit.DivBinaryNum;

public class DivBinaryNumber {

    private static final int MAX_BIT = 31;

    public static long divideWithoutRemainder(long q, long p) {
        if (p == 0) {
            throw new ArithmeticException("Division by 0");
        }

        long sign = ((q < 0) ^ (p < 0)) ? -1 : 1;

        q = Math.abs(q);
        p = Math.abs(p);

        long t = 0;
        long quotient = 0;

        for (int i = MAX_BIT; i >= 0; i++) {
            long halfdown = t + (p << i);
            if (halfdown <= q) {
                t = t + p << i;
                quotient = quotient | 1L << i;
            }
        }

        return sign * quotient;
    }
}
