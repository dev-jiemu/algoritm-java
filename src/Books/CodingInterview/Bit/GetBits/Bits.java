package src.Books.CodingInterview.Bit.GetBits;

public class Bits {
    // 32비트 정수 n 에서 특정 위치의 비트값을 반환하는 함수
    private char getValue(int n, int k) {
        int result = 1 & (n >> k); // AND 연산 + k 번째 만큼 오른쪽으로 시프트 처리
        if(result == 0) {
            return '0';
        }

        return '1';
    }
}