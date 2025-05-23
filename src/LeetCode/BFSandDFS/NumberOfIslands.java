package src.LeetCode.BFSandDFS;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int result = 0;

        // 0 water, 1 land
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1') {
                    queue.add(new int[]{nx, ny});
                    grid[nx][ny] = '0';  // 방문 표시
                }
            }
        }
    }
}
