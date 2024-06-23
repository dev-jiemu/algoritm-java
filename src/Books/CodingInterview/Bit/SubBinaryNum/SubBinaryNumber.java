package src.Books.CodingInterview.Bit.SubBinaryNum;

public class SubBinaryNumber {

    // 이진수 뺄셈
    public static int subtract(int q, int p) {
        while(p != 0) {

            int borrow = (~q) & p;

            q = q ^ p; // 비트 중에 하나 이상이 0이면 q에서 p를 뺌

            p = borrow << 1;
        }

        return q;
    }
}
