package src.LeetCode.Greedy;

// https://leetcode.com/problems/wiggle-subsequence/description/?envType=problem-list-v2&envId=greedy
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            } // 해당되는거 없으면 값 변화 자체가 없음
        }

        return Math.max(up, down);
    }
}
