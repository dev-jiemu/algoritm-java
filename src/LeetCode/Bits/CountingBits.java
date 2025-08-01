package src.LeetCode.Bits;

public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        // DP
        for(int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
