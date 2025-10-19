package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/new-21-game/?envType=problem-list-v2&envId=sliding-window
public class New21Game {
    // Sliding Window + DP
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1.0; // 특수케이스

        int maxScore = k - 1 + maxPts;
        double[] dp = new double[maxScore + 1];

        for (int i = k; i <= maxScore; i++) {
            dp[i] = (i <= n) ? 1.0 : 0.0;
        }

        // dp[k] + dp[k+1] + ... + dp[k+maxPts-1]
        double windowSum = 0;
        for (int i = k; i < k + maxPts && i <= maxScore; i++) {
            windowSum += dp[i];
        }

        // * 역방향으로 DP 계산
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = windowSum / maxPts;

            windowSum += dp[i];  // 새로 계산한 dp[i] 추가
            if (i + maxPts <= maxScore) {
                windowSum -= dp[i + maxPts];  // 범위 벗어난 값 제거
            }
        }

        return dp[0];
    }
}
