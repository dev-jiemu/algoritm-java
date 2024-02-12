package src.Books.ProgrammersTest.GraphAndTree;

// https://school.programmers.co.kr/learn/courses/30/lessons/49191
public class Ranking {

    public int solution(int n, int[][] results) {
        // (이긴 선수들의 수 + 진 선수들의 수 + 1) = 전체 선수의 수
        int answer = 0;

        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }

        for (int u = 0; u < n; u++) {
            int wins = countForward(u, graph, new boolean[n]) - 1;
            int loses = countBackward(u, graph, new boolean[n]) - 1;

            if (wins + loses + 1 == n) {
                answer++;
            }
        }

        return answer;
    }

    // 이긴경우
    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            // 정점 v는 정점 u와 연결된 간선이 있고, 이전에 방문한 적이 없으면 진행
            if (!graph[u][v] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countForward(v, graph, isVisited); // 재귀
        }

        return count;
    }

    // 진경우
    private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph.length; v++) {
            if(!graph[v][u] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }

        return count;
    }
}
