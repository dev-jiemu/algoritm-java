package src.Books.ProgrammersTest.KakaoBlind;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/92343
public class SheepAndWolf {
    // 늑대 개수 <= 양 개수 일때 최대치
    public int solution(int[] info, int[][] edges) {
        boolean[][] tree = new boolean[info.length][info.length];
        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
        }

        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);

        return getMaxSheep(nodes, 0,  0, info, tree);
    }

    // 후보 노드 찾음
    private Set<Integer> getNextNodes(int node, Set<Integer> nodes, boolean[][] tree) {
        Set<Integer> nextNodes = new HashSet<>(nodes);
        nextNodes.remove(node); // 가장 먼저 방문하는건 제거

        for (int next = 0; next < tree[node].length; next++) {
            if (!tree[node][next]) {
                continue;
            }
            nextNodes.add(next);
        }

        return nextNodes;
    }

    private int getMaxSheep(Set<Integer> nodes, int sheep, int wolf, int[] info, boolean[][] tree) {
        int maxSheep = sheep;

        for (int node : nodes) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            // 0 이면 양, 1이면 늑대
            if (info[node] == 0) {
                nextSheep += 1;
            } else {
                nextWolf += 1;
            }

            if (nextWolf >= nextSheep) {
                continue; // wolf >= sheep 이면 건너뜀
            }

            int s = getMaxSheep(getNextNodes(node, nodes, tree), nextSheep, nextWolf, info, tree);
            if (s > maxSheep) {
                maxSheep = s;
            }
        }

        return maxSheep;
    }
}
