package src.LeetCode.Matrix;

// 1895. Largest Magic Square
// https://leetcode.com/problems/largest-magic-square/description/
public class LargestMagicSquare {
    // O(min(m,n) × m × n × k)
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 1x1 부터 늘려야 하나 생각했는데 그냥 빼면 되는거였네 ㅇㅂㅇ
        int maxK = Math.min(m, n); // 정사각형이라서

        for (int k = maxK; k >= 1; k--) {
            for (int row = 0; row <= m - k; row++) {
                for (int col = 0; col <= n - k; col++) {
                    if (isMagic(grid, row, col, k)) {
                        return k;
                    }
                }
            }
        }

        return 1; // 이론상 여기 안옴 ㅇㅇ
    }

    private boolean isMagic(int[][] grid, int row, int col, int k) {
        int target = 0;
        for (int j = 0; j < k; j++) {
            target += grid[row][col + j]; // 첫 행 합을 기준값으로
        }

        // 나머지 행 합 체크
        for (int i = 1; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) sum += grid[row + i][col + j];
            if (sum != target) {
                return false;
            }
        }

        // 열 합 체크
        for (int j = 0; j < k; j++) {
            int sum = 0;
            for (int i = 0; i < k; i++) sum += grid[row + i][col + j];
            if (sum != target) {
                return false;
            }
        }

        // 대각선 두 개 체크
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[row + i][col + i];
            diag2 += grid[row + i][col + k - 1 - i];
        }

        if (diag1 != target || diag2 != target) {
            return false;
        }

        return true;
    }
}
