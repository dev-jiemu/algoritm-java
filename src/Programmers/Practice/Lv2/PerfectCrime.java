package src.Programmers.Practice.Lv2;

import java.util.*;

// 완전범죄
// https://school.programmers.co.kr/learn/courses/30/lessons/389480?language=java
public class PerfectCrime {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0; // 초기 상태

        for (int item = 0; item < itemCount; item++) {
            for (int a = n - 1; a >= 0; a--) {
                for (int b = m - 1; b >= 0; b--) {
                    if (dp[a][b] == -1) continue;

                    // A가 훔치는 경우
                    int newA = a + info[item][0];
                    if (newA < n) {
                        dp[newA][b] = Math.max(dp[newA][b], dp[a][b] + 1);
                    }

                    // B가 훔치는 경우
                    int newB = b + info[item][1];
                    if (newB < m) {
                        dp[a][newB] = Math.max(dp[a][newB], dp[a][b] + 1);
                    }
                }
            }
        }

        // 모든 물건을 훔칠 수 있는 경우 중에서 A의 흔적이 최소인 값 찾기
        int minATrace = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b] == itemCount) { // 모든 물건을 훔친 경우
                    minATrace = Math.min(minATrace, a);
                }
            }
        }

        return minATrace == Integer.MAX_VALUE ? -1 : minATrace;
    }
}