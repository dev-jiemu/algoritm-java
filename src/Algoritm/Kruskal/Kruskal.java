package src.Algoritm.Kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    // union 연산 : 그룹 요소의 젤 작은 노드를 부모로 간주함
    public static void union(int[] parent, int a, int b) {
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i) { return i; } // 부모일 경우
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        // (x, y, 가중치)
        int [][]graph = {{1, 2, 6}, {1, 3, 3}, {1, 4, 1}, {2, 5, 4}, {3, 4, 2}, {3, 5, 5}, {4, 5, 7}};

        int count = kruskal(graph);
        System.out.println("result : " + count);
    }

    public static int kruskal(int[][] graph) {
        int total = 0;

        int []parent = new int[graph.length - 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 가중치 정렬
        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) { // 사이클을 형성하지 않으면
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]); // 서로 다른 노드니까 union 연산으로 합침
            }
        }

        return total;
    }

}
