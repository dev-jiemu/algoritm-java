package src.LeetCode.DynamicProgramming;

// 931. Minimum Falling Path Sum
// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {

    // 따로 dp 배열 만들 필요없이 사용하면 될듯
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for(int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int best = matrix[r - 1][c];
                if (c > 0) {
                    best = Math.min(best, matrix[r - 1][c - 1]); // 왼쪽 위
                }

                if (c < n - 1) {
                    best = Math.min(best, matrix[r - 1][c + 1]); // 오른쪽 위
                }

                matrix[r][c] += best;
            }
        }

        // 마지막 행만 보면 될듯
        int answer = Integer.MAX_VALUE;
        for(int c = 0; c < n; c++) {
            answer = Math.min(answer, matrix[n - 1][c]);
        }

        return answer;
    }
}
