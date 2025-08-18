package src.LeetCode.Backtracking;

// https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150
public class WordSearch {
    // 구조상 2차원 배열은 쩔수일듯
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // 모든 셀에서 시작점으로 시도
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;

        // 경계를 초과했거나 문자열이 없을 경우
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*'; // visited

        // 4방향으로 탐색
        boolean found = dfs(board, word, i+1, j, index+1) ||
                dfs(board, word, i-1, j, index+1) ||
                dfs(board, word, i, j+1, index+1) ||
                dfs(board, word, i, j-1, index+1);

        board[i][j] = temp; // 백트래킹

        return found;
    }
}
