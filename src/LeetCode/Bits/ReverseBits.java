package src.LeetCode.Bits;

// https://leetcode.com/problems/reverse-bits/?envType=study-plan-v2&envId=top-interview-150
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        // 32비트 처리
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1); // 최하위 비트 -> 최상위 비트로 추가
            n >>= 1;
        }

        return result;
    }
}
