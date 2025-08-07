package src.LeetCode.Bits;

public class Numberof1Bits {
//    public int hammingWeight(int n) {
//        return Integer.bitCount(n); // 비트 카운트...
//    }

    // n, n-1 끼리 and 연산하면 오른쪽 1이 제거됨 -> 0이 될때까지 제거하는 count 수가 1 bits count nums
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);  // 가장 오른쪽 1을 제거
            count++;
        }
        return count;
    }
}
