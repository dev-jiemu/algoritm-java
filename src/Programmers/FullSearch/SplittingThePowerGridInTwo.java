package src.Programmers.FullSearch;

import java.util.*;

// 전력망을 둘로 나누기 : https://school.programmers.co.kr/learn/courses/30/lessons/86971
// BFS 연습문제
// Ref. https://dev-musa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%EC%A0%84%EB%A0%A5%EB%A7%9D-%EC%9E%90%EB%A5%B4%EA%B8%B0-BFS

public class SplittingThePowerGridInTwo {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        for (int[] wire : wires) {
            int network1 = bfs(wire[0], wire[1], tree, n);
            int network2 = bfs(wire[1], wire[0], tree, n);
            answer = Math.min(Math.abs(network1 - network2), answer);
        }
        return answer;
    }

    private int bfs(int node1, int node2, List<Integer>[] tree, int n) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1]; // bfs 실행할때마다 방문체크 1회씩 진행
        visited[node1] = true;
        queue.add(node1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : tree[current]) {
                if (!visited[next] && next != node2) {
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        SplittingThePowerGridInTwo splittingThePowerGridInTwo = new SplittingThePowerGridInTwo();

        int result = splittingThePowerGridInTwo.solution(n, wires);
        System.out.println("result : " + result);
    }
}
