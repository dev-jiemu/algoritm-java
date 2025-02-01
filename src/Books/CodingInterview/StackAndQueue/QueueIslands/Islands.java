package src.Books.CodingInterview.StackAndQueue.QueueIslands;

import src.Books.CodingInterview.StackAndQueue.Cell;

import java.util.*;

public class Islands {
    private static final int[] ROW = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] COL = {-1, 1, 0, -1, -1, 1, 0, 1};

    private static final int POSSIBLE_MOVEMENT = 8; // 최대 8개 이동

    // 칸의 좌표가 행렬 밖으로 나가면 안됨
    // 값이 1일때 (= 토지)
    // 이전에 방문한 좌표가 아닐때
    private static boolean isValid(int[][] matrix, int r, int c, boolean[][] flagged) {
        return (r >= 0) && (r < flagged.length) && (c >= 0) && (c < flagged[0].length) && (matrix[r][c] == 1 && !flagged[r][c]);
    }

    private static void resolve(int[][] matrix, boolean[][] flagged, int i, int j) {
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(i, j));

        flagged[i][j] = true;

        while(!queue.isEmpty()) {
            int r = queue.peek().r;
            int c = queue.peek().c;
            queue.poll();

            for(int k = 0; k < POSSIBLE_MOVEMENT; k++) {
                if(isValid(matrix, r + ROW[k], c + COL[k], flagged)) {
                    flagged[r + ROW[k]][c + COL[k]] = true;
                    queue.add(new Cell(r + ROW[k], c + COL[k]));
                }
            }
        }
    }

    // queue
    public static int islands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] flagged = new boolean[m][n];

        int island = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !flagged[i][j]) { // 섬일때 체크
                    resolve(matrix, flagged, i, j);
                    island++;
                }
            }
        }

        return island;
    }
}
