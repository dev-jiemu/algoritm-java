package src.Books.CheetSheetWithLeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // 일단 .로 초기화
        }

        backtrack(board, 0);
        return result;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;

            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.'; // 백트래킹
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
