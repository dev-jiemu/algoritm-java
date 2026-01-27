package src.LeetCode.Hash;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];      // 각 행에 있는 숫자들
        Set<Integer>[] cols = new HashSet[9];      // 각 열에 있는 숫자들
        Set<Integer>[] boxes = new HashSet[9];     // 각 3x3 박스에 있는 숫자들

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // 기존 숫자 기입
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] != '.') {
                    int num = board[row][col] - '0';
                    int boxIndex = (row / 3) * 3 + (col / 3);
                    rows[row].add(num);
                    cols[col].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }

        backtracking(board, rows, cols, boxes, 0, 0);
    }

    private boolean backtracking(char[][] board, Set<Integer>[] rows, Set<Integer>[] cols, Set<Integer>[] boxes, int row, int col) {
        if(col == 9) {
            return backtracking(board, rows, cols, boxes, row + 1, 0); // next row
        }

        if (row == 9) {
            return true; // 종료
        }

        if(board[row][col] != '.') {
            return backtracking(board, rows, cols, boxes, row, col + 1);
        }

        int boxIndex = (row / 3) * 3 + (col / 3);

        for(int num = 1; num <= 9; num++) {
            if(!rows[row].contains(num) && !cols[col].contains(num) && !boxes[boxIndex].contains(num)) {

                board[row][col] = (char)(num + '0');
                rows[row].add(num);
                cols[col].add(num);
                boxes[boxIndex].add(num);

                if(backtracking(board, rows, cols, boxes, row, col + 1)) {
                    return true;
                }

                // 백트래킹
                board[row][col] = '.';
                rows[row].remove(num);
                cols[col].remove(num);
                boxes[boxIndex].remove(num);
            }
        }

        return false;
    }
}
