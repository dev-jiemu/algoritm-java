package src.LeetCode.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1514. Path with Maximum Probability
// https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 디익스트라 응용버전 : 확률 곱의 최대값을 우선순위로
        List<List<double[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new double[]{b, prob});
            graph.get(b).add(new double[]{a, prob});
        }

        // 최대확률 저장 배열
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        // 정렬 반대로 해야됨 - 확률 곱의 최대값이 우선순위라서
        PriorityQueue<double[]> pq = new PriorityQueue<>((x, y) -> Double.compare(y[1], x[1]));
        pq.offer(new double[]{start_node, 1.0});

        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];

            if (node == end_node) { // 찾았으니까 더 볼필요 없음
                return prob;
            }

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            for (double[] neighbor : graph.get(node)) {
                int next = (int) neighbor[0];
                double edgeProb = neighbor[1];
                double newProb = prob * edgeProb;

                if (newProb > maxProb[next]) { // 최대값 갱신
                    maxProb[next] = newProb;
                    pq.offer(new double[]{next, newProb});
                }
            }
        }

        return 0.0; // 도달 불가
    }
}
