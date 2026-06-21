package src.LeetCode.Array;

import java.util.Arrays;

// 1968. Array With Elements Not Equal to Average of Neighbors
// https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    // 반절만 돌리기
//    public int[] rearrangeArray(int[] nums) {
//        Arrays.sort(nums);
//        int[] result = new int[nums.length];
//
//        int mid = (nums.length + 1) / 2;
//        for(int i = 0; i < mid; i++) {
//            result[2 * i] = nums[i];
//            if(2 * i + 1 < nums.length) { // 큰 절반 자리만 남으면
//                result[2 * i + 1] = nums[mid + i];
//            }
//        }
//
//        return result;
//    }
    // 인접쌍으로 스왑만 하면
    public int[] rearrangeArray(int[] nums) {
        // 정렬을 해두면 swap 했을때 홀수자리는 양옆보다 작고, 짝수자리는 큰값이 됨
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }

        return nums;
    }
}
