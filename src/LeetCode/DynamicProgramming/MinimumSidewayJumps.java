package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/minimum-sideway-jumps/
public class MinimumSidewayJumps {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1}; // 시작이 레인 2임

        int INF = Integer.MAX_VALUE / 2; // 장애물 표시용
        for (int i = 1; i < obstacles.length; i++) {
            // 뒤에꺼 있으면 막기
            if (obstacles[i] != 0) dp[obstacles[i] - 1] = INF;

            int a = dp[0], b = dp[1], c = dp[2];

            dp[0] = Math.min(a, Math.min(b, c) + 1);
            dp[1] = Math.min(b, Math.min(a, c) + 1);
            dp[2] = Math.min(c, Math.min(a, b) + 1);

            // 장애물 레인 다시 막기
            // 이거 안막으면 다음 계산에서 덮어씌워짐 ㅠ
            if (obstacles[i] != 0) dp[obstacles[i] - 1] = INF;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
