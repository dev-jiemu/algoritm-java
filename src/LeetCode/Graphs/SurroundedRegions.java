package src.LeetCode.Graphs;

// https://leetcode.com/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) { return; }

        int m = board.length;
        int n = board[0].length;

        // 가장자리 처리
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m-1][j] == 'O') dfs(board, m-1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O'; // 가장자리 처리 해논거 원복
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        // 가장자리에서 시작하는 O는 X로 치환하면 안됨
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
