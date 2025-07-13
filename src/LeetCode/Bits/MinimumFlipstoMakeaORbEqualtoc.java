package src.LeetCode.Bits;

// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75
public class MinimumFlipstoMakeaORbEqualtoc {
    public int minFlips(int a, int b, int c) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            int orResult = bitA | bitB;

            if (orResult != bitC) {
                if (bitC == 1) {
                    result++; // 0 이면 a 또는 b 중 하나만 바꾸면 되니까
                } else {
                    result += bitA + bitB;
                }
            }
        }

        return result;
    }
}
