package src.LeetCode.Matrix;

// https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
public class GameofLife {
    public void gameOfLife(int[][] board) {
        // in place (bit)
        // 현재상태, 다음상태 동시에 저장함
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                if ((board[i][j] & 1) == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] = 3; // 11 = 살아남음
                    }
                    // 아니면 죽은거임 :: 01 == 살아있음->죽음
                } else {
                    if(liveNeighbors == 3) {
                        board[i][j] = 2; // 10 == 죽음->살아있음
                    }
                }
            }
        }

        // 상태 업데이트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    count += board[newRow][newCol] & 1; // 두번째비트 :: 현재 상태만 확인함
                }
            }
        }

        return count;
    }
}
