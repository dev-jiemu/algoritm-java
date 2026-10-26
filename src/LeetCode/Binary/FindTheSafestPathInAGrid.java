package src.LeetCode.Binary;

import java.util.*;

// 2812. Find the Safest Path in a Grid
// https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/
public class FindTheSafestPathInAGrid {
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // BFS : 가장 가까운 도둑까지의 거리
        int[][] dist = new int[n][n];
        for(int[] row : dist) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new ArrayDeque<>();
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                // 도둑임
                if(grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    q.add(new int[] {r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n || dist[nr][nc] != -1) { // 도둑이면 건너뜀
                    continue;
                }

                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[] {nr, nc});
            }
        }

        // binary search
        // 정답이 될 수 있는 값의 범위를 나눔
        int lo = 0;
        int hi = Math.min(dist[0][0], dist[n - 1][n - 1]);

        while(lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if(canReach(dist, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    // dist >= k 인 칸만 밟아서 (0, 0) -> (n-1, n-1) 이 되는지 확인하기
    private boolean canReach(int[][] dist, int k) {
        int n = dist.length;
        if(dist[0][0] < k) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == n - 1 && cur[1] == n - 1) {
                return true;
            }
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                if(visited[nr][nc] || dist[nr][nc] < k) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }

        return false;
    }
}
