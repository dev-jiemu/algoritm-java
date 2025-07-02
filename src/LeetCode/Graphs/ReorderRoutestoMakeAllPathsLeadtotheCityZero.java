package src.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            // a -> b
            graph.get(a).add(new int[]{b, 1});
            // b -> a
            graph.get(b).add(new int[]{a, 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] edge : graph.get(node)) {
            int nextNode = edge[0];
            int direction = edge[1];

            if (!visited[nextNode]) {
                count += direction; // 원래 방향이면 뒤집어야 함
                count += dfs(nextNode, graph, visited);
            }
        }

        return count;
    }
}
