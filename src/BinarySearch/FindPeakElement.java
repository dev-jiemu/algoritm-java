package src.BinarySearch;

// https://leetcode.com/problems/find-peak-element/submissions/1675714671/?envType=study-plan-v2&envId=leetcode-75
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }
}
