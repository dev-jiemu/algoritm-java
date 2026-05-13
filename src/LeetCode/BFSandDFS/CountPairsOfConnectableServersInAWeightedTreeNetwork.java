package src.LeetCode.BFSandDFS;

import java.util.ArrayList;
import java.util.List;

public class CountPairsOfConnectableServersInAWeightedTreeNetwork {
    private List<int[]>[] graph;
    private int signalSpeed = 0;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        int[] result = new int[n];
        this.signalSpeed = signalSpeed;

        this.graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int weight = edge[2];
            graph[a].add(new int[]{b, weight});
            graph[b].add(new int[]{a, weight});
        }

        // 각 노드를 중간 서버로 설정
        for (int i = 0; i < n; i++) {
            result[i] = countPairs(i);
        }

        return result;
    }

    private int countPairs(int root) {
        List<Integer> subtreeCounts = new ArrayList<>();

        for(int[] edge : graph[root]) {
            int child = edge[0];
            int weight = edge[1];

            // 이 서브트리에서 연결 가능한 노드 수
            int count = dfs(child, root, weight);
            subtreeCounts.add(count);
        }

        // 서로 다른 서브트리에서 쌍 만들기
        int totalPairs = 0;
        int sum = 0;

        for (int count : subtreeCounts) {
            // 현재 서브트리의 노드들과 이전 서브트리들의 노드들을 조합함
            totalPairs += count * sum;
            sum += count;
        }

        return totalPairs;
    }

    private int dfs(int node, int parent, int distance) {
        int count = 0;

        // 현재 노드가 조건을 만족하면 카운트처리
        if (distance % this.signalSpeed == 0) {
            count++;
        }

        // 자식 노드들 탐색
        for (int[] edge : graph[node]) {
            int neighbor = edge[0];
            int weight = edge[1];

            // 부모로 돌아가지 않도록 해야됨
            if (neighbor == parent) {
                continue;
            }

            count += dfs(neighbor, node, distance + weight);
        }

        return count;
    }
}
