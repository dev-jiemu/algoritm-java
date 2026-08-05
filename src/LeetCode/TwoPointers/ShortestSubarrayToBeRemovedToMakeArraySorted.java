package src.LeetCode.TwoPointers;

// 1574. Shortest Subarray to be Removed to Make Array Sorted
// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return 0; // 이미 정렬됨
        }

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // 한쪽이 통째로 사라짐
        int result = Math.min(n - left - 1, right);

        int i = 0;
        int j = right;

        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
