package src.LeetCode.Binary;

// https://leetcode.com/problems/cycle-length-queries-in-a-tree/description/
public class CycleLengthQueriesInATree {
    /*
    - 부모 = i / 2
    - 왼쪽 자식 = 2 * i
    - 오른쪽 자식 = 2 * i + 1
     */
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            // LCA(최소 공통 조상) 찾기
            int cycleLength = findCycleLength(a, b);
            answer[i] = cycleLength;
        }

        return answer;
    }

    // LCA (Lowest Common Ancestor, 최소 공통 조상)
    private int findCycleLength(int a, int b) {
        int lca = findLCA(a, b);

        int distA = 0;
        int nodeA = a;
        while (nodeA != lca) {
            nodeA = nodeA / 2;
            distA++;
        }

        int distB = 0;
        int nodeB = b;
        while (nodeB != lca) {
            nodeB = nodeB / 2;
            distB++;
        }

        // 트리 경로 : a -> LCA -> b (distA + distB)
        return distA + distB + 1; // 추가 간선 + 1 (이게 사이클을 형성함!)
    }

    // 완전이진트리니까 node / 2 =  부모노드
    private int findLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
        }

        return a;  // a와 b가 만나는 지점이 LCA
    }
}
