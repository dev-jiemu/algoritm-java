package src.LeetCode.Graphs;

// 1615. Maximal Network Rank
// https://leetcode.com/problems/maximal-network-rank/
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 노드 연결개수 확인
        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            degree[a]++;
            degree[b]++;
            connected[a][b] = true;
            connected[b][a] = true;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j] - (connected[i][j] ? 1 : 0); // 중복된거 빼야함
                max = Math.max(max, rank);
            }
        }

        return max;
    }
}
