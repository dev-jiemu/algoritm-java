package src.LeetCode.Bits;

// 2275. Largest Combination With Bitwise AND Greater Than Zero
// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {
        int answer = 0;
        // 문제에서 말하는 제약조건 : 1 <= candidates[i] <= 1^7 == 최대 24비트
        // 어느 한 비트 자리라도 모두 1이면 AND > 0 이 보장됨
        for (int i = 0; i < 24; i++) {
            int count = 0;
            for (int num : candidates) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
