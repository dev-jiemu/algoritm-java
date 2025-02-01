package src.Books.CodingInterview.StackAndQueue.ShortestSafeRoute;

import src.Books.CodingInterview.StackAndQueue.Cell;

import java.util.ArrayDeque;
import java.util.Queue;

// 너비 우선 탐색
public class ShortestRoute {
    private static final int M = 10;
    private static final int N = 10;

    // 위, 오른쪽, 아래, 왼쪽
    private static final int[] ROW_4 = {-1, 0, 0, 1};
    private static final int[] COL_4 = {0, -1, 1, 0};

    // 위, 오른쪽, 아래, 왼쪽, 대각선 4가지 뱡향
    private static final int[] ROW_8 = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_8 = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int findShortestPath(int[][] board) {
        boolean[][] visited = new boolean[M][N];
        Queue<Cell> queue = new ArrayDeque<>();

        for (int r1 = 0; r1 < M; r1++) {
            if(board[r1][0] == 1) {
                queue.add(new Cell(r1, 0, 0));
                visited[r1][0] = true;
            }
        }

        while(!queue.isEmpty()) {
            int rIdx = queue.peek().r;
            int cIdx = queue.peek().c;
            int dist = queue.peek().distance;

            queue.poll();

            if (cIdx == N - 1) {
                return (dist + 1);
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(rIdx + ROW_4[k], cIdx + COL_4[k]) && isSafe(board, visited, rIdx + ROW_4[k], cIdx + COL_4[k])) {
                    visited[rIdx + ROW_4[k]][cIdx + COL_4[k]] = true;
                    queue.add(new Cell(rIdx + ROW_4[k], cIdx + COL_4[k], dist + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isSafe(int[][] board, boolean[][] visited, int r, int c) {
        return (board[r][c] == 1 && !visited[r][c]);
    }

    // (r, c) 칸이 행렬에 있는지 확인합니다.
    private static boolean isValid(int r, int c) {
        return (r < M && c < N && r >= 0 && c >= 0);
    }
}
