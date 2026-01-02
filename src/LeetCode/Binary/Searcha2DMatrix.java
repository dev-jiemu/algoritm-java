package src.LeetCode.Binary;

// https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
public class Searcha2DMatrix {
    // O log(m * n)
    public boolean searchMatrix(int[][] matrix, int target) {
        // left, right
        // 그냥 단순하게 1차원 배열로 생각해보면
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
