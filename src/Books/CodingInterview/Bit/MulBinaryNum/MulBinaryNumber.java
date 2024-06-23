package src.Books.CodingInterview.Bit.MulBinaryNum;

public class MulBinaryNumber {

    // 코드로 이진수 곱하기
    public static int multiply(int q, int p) {
        int result = 0;

        while (p != 0) {
            // 최하위 비트 1일때
            if ((p & 1) != 0) {
                result = result + q;
            }

            q = q << 1;   // 왼쪽
            p = p >>> 1;  // 오른쪽
        }

        return result;
    }
}
