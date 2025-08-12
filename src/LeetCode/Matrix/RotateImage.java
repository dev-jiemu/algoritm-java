package src.LeetCode.Matrix;

// https://leetcode.com/problems/rotate-image/submissions/1732471002/?envType=study-plan-v2&envId=top-interview-150
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 대각선 먼저
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 좌우반전 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
