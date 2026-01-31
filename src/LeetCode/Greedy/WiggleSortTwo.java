package src.LeetCode.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/wiggle-sort-ii/?envType=problem-list-v2&envId=greedy
public class WiggleSortTwo {
    public void wiggleSort(int[] nums) {
        // 정렬하고 반으로 나눠서 맞추면 될듯
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = nums.length;
        int mid = (n + 1) / 2;

        int left = mid - 1;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            // 짝수 인덱스 = 작은값, 홀수 인덱스 = 큰 값
            if (i % 2 == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }
}
