package src.Books.CodingInterview.Bit.BitSetting;

public class BitSetting {
    // 32비트 정수 n 기준으로 주어진 위치 k의 있는 n의 비트값 변경

    // 0으로 바꿀때
    private int setValueTo0(int n, int k) {
        return n & ~(1 << k); // k가 3, 4, 6 일때
    }

    // 1로 바꿀때
    private int setValueTo1(int n, int k) {
        return n | (1 << k); // k가 0, 1, 2, 5 일때
    }
}
