package src.LeetCode.DynamicProgramming;

// 3129. Find All Possible Stable Binary Arrays I
// https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/description/
// TODO : 케이스 통과 안됨 수정해야됨 ㅠ
public class FindAllPossibleStableBinaryArrays {
    private static final int MOD = 1_000_000_007;

    // limit 보다 긴 부분배열인데 반드시 0, 1 다 포함해야함 = 같은 숫자가 연속으로 limit을 넘으면 안됨
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];

        for (int i = 1; i <= Math.min(limit, one); i++) {
            dp[0][i][1] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                // 0 작업함
                for (int k = 1; k <= Math.min(limit, i); k++) {
                    if (i - k == 0 && j == 0) continue; // 앞에 아무것도 없는 경우는 base case에서 이미 처리
                    dp[i][j][0] = (dp[i][j][0] + dp[i - k][j][1]) % MOD;
                }

                //  직전에 0으로 끝난 상태(dp[i][j-L][0])에 1을 k개 붙임
                for (int k = 1; k <= Math.min(limit, j); k++) {
                    if (j - k == 0 && i == 0) continue;
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j - k][0]) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
