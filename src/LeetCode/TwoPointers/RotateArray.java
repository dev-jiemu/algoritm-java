package src.LeetCode.TwoPointers;

// https://leetcode.com/problems/rotate-array/description/?envType=problem-list-v2&envId=two-pointers
public class RotateArray {
    public void rotate(int[] nums, int k) {
        // k 값 정규화 : nums.length 보다 크게 올 경우 사실상 length 만큼 도는거라 의미없음
        k = k % nums.length;

        // 전체 뒤집기
        reverse(nums, 0, nums.length - 1);

        // k개 뒤집기
        reverse(nums, 0, k - 1);

        // 나머지 뒤집기
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
