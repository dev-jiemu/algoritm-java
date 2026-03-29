package src.LeetCode.PrefixSum;

// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int result = 0;

        int row = mat.length;
        int col = mat[0].length;

        int maxLen = Math.min(row, col); // 정사각형이니까 m, n 중 작은 숫자까지만 슬라이드 확장 가능함

        // 이전값 기반으로 배열 미리 만들어두기 ㅇㅂㅇ
        int[][] prefixSum = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefixSum[i][j] = mat[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        for (int k = 1; k <= maxLen; k++) {
            for (int i = 0; i <= row - k; i++) {
                for (int j = 0; j <= col - k; j++) {
                    int sum = prefixSum[i+k][j+k] - prefixSum[i][j+k] - prefixSum[i+k][j] + prefixSum[i][j];
                    if (sum <= threshold) {
                        result = k;
                    }
                }
            }
        }

        return result;
    }
}
