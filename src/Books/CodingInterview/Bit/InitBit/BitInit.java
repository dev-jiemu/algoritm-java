package src.Books.CodingInterview.Bit.InitBit;

public class BitInit {
    // 최상위 비트와 위치 k 사이에 있는 n의 모든 비트를 초기화(0)하는 코드
    // and연산

    /*
    ex)
    1. k = 6일때 왼쪽 시프트로 6번 함 = 1000000
    2. 여기서 1뺌 = 0111111
    3. AND 연산
     */
    public int clearFromMsb(int n, int k) {
        return n & ((1 << k) - 1);
    }

    // k 부터 최하위 비트까지 초기화
    public int clearFromPosition(int n, int k) {
        //return n & ~((1 << k) - 1);
        return n & -(1 << k);
    }
}
