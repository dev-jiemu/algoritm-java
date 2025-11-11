package src.LeetCode.BFSandDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    // 사실 DP로 풀수 있긴 함
    public int numSquaresDp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }

    // BFS 로 풀면?
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(0); // 여기서 시작
        visited[0] = true;
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for(int i = 0; i < size; i++) {
                int current = queue.poll();

                for(int j = 1; j * j <= n; j++) {
                    int next = current + j * j;

                    if (next == n) {return level;}

                    if (next < n && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return level;
    }
}
