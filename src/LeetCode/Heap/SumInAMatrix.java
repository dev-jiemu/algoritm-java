package src.LeetCode.Heap;

import java.util.Arrays;

// https://leetcode.com/problems/sum-in-a-matrix/description/
public class SumInAMatrix {
    public int matrixSum(int[][] nums) {
        // 예시만 놓고보면 정렬된것 같은데... 혹시몰라서 정렬
        for(int[] row : nums){
            Arrays.sort(row); // 오름차순임 : 역순으로 접근해야함
        }

        int max = 0;
        int col = nums[0].length;
        for (int j = col - 1; j >= 0; j--) {  // 뒤에서부터 접근
            int maxVal = 0;
            for (int i = 0; i < nums.length; i++) {
                maxVal = Math.max(maxVal, nums[i][j]);
            }
            max += maxVal;
        }

        return max;
    }
}
