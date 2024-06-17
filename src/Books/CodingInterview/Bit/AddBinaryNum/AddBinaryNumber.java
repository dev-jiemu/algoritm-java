package src.Books.CodingInterview.Bit.AddBinaryNum;

public class AddBinaryNumber {
    // 32비트 정수 2개
    // p + q = 2 * (p & q) + (p ^ q)
    // 2 * and + xor
    public static int sum(int q, int p) {
        int xor = q ^ p;
        int and = q & p;
        int t = 0;

        // 0이 될때까지 재귀
        while(and != 0) {
            and = and << 1; // 2를 곱함

            t = xor ^ and;
            and = and & xor;
            xor = t;
        }

        return xor;
    }
}
