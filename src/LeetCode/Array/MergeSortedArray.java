package src.LeetCode.Array;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/submissions/1688207043/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m = pointer

        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}
