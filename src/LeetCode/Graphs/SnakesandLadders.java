package src.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150
public class SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[] visited = new boolean [n * n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            if (square == n * n) {
                return moves;
            }

            // 1 ~ 6 주사위 굴리기
            for (int dice = 1; dice <= 6; dice++) {
                int nextSquare = square + dice;

                // 보드 범위 체크
                if (nextSquare > n * n) {
                    break;
                }

                int[] pos = getPosition(nextSquare, n);
                int row = pos[0];
                int col = pos[1];

                int finalSquare = nextSquare;
                if (board[row][col] != -1) {
                    finalSquare = board[row][col]; // 뱀/사다리 목적지로 이동
                }

                // 방문체크
                if (!visited[finalSquare]) {
                    visited[finalSquare] = true;
                    queue.offer(new int[]{finalSquare, moves + 1});
                }
            }
        }

        return -1;
    }

    // 왼쪽 <-> 오른쪽 스위칭 계산
    private int[] getPosition(int square, int n) {
        square--; // 0-based로 변환 (계산 편의상)

        int row = square / n; // 아래에서부터 몇 번째 행인지
        int col = square % n; // 행 내에서의 위치

        // 홀수 행 (1, 3, 5...)은 오른쪽에서 왼쪽으로
        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        // 배열은 위에서부터 시작하므로 row를 뒤집기
        row = n - 1 - row;

        return new int[]{row, col};
    }
}
