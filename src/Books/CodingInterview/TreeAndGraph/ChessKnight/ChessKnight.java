package src.Books.CodingInterview.TreeAndGraph.ChessKnight;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ChessKnight {
    // 너비 우선 탐색
    // 모든 칸의 최단거리 : 부모 칸의 최단거리 + 1
    private class Node {
        // (r, c): 체스판 좌표, (row, column)
        // distance: 시작 칸과의 최소 거리
        private final int r;
        private final int c;
        private int distance;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    // 이동 가능한 8가지 수
    private static final int[] ROW = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] COL = {-1, 1, 1, -1, 2, -2, 2, -2};

     /*
        1. 빈 큐 생성
        2. 시작 칸을 큐에 넣고 자신까지의 거리가 0이 되도록 설정
        3. 큐가 비워질 때까지 반복
            - 큐에서 방문 안한 다음칸은 pop
            - pop한 칸이 도착칸이면 return
            - 그 외엔 방문했다고 표시하고 거리 1 늘리고 8개칸 큐에 push
     */
    private int countKnightMoves(Node startCell, Node targetCell, int n) {
        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startCell);

        while(!queue.isEmpty()) {
            Node cell = queue.poll();

            int r = cell.r;
            int c = cell.c;
            int distance = cell.distance;

            if (r == targetCell.r && c == targetCell.c) {
                return distance;
            }

            // 방문하지 않은 칸 처리
            if (!visited.contains(cell)) {
                visited.add(cell);

                for(int i = 0; i < 8; i++) {
                    int rt = r + ROW[i];
                    int ct = c + COL[i];

                    if (valid(rt, ct, n)) {
                        queue.add(new Node(rt, ct, distance + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean valid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}
