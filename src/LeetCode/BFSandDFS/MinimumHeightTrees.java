package src.LeetCode.BFSandDFS;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/description/?envType=problem-list-v2&envId=depth-first-search
public class MinimumHeightTrees {

    // 위상정렬
    /*
        리프 노드(연결이 1개인 노드)를 찾음
        리프 노드들을 제거하고, 새로운 리프 노드 찾기
        남은 노드가 1~2개가 될 때까지 반복
        마지막 남은 노드들이 답 (트리의 중심)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 리프노드 찾기
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remaining = n;
        while (remaining > 2) { // 남은 노드가 1~2개가 될때까지
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
