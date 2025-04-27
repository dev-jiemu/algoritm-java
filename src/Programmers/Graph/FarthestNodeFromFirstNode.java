package src.Programmers.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNodeFromFirstNode {
    public int solution(int n, int[][] edges) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 간선 표현 1 - 2, 1 - 3...
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 방문 표기
        int[] distance = new int[n + 1]; // 1번부터 ㅇㅇ
        Arrays.fill(distance, -1); // default -1
        distance[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // start

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int node : graph.get(current)) {
                if(distance[node] == -1) {
                    distance[node] = distance[current] + 1;
                    queue.offer(node);
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }

        return answer;
    }


}
