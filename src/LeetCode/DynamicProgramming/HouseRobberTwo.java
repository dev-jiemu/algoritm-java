package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/house-robber-ii/?envType=problem-list-v2&envId=dynamic-programming
public class HouseRobberTwo {
    public int rob(int[] nums) {
        // 원형배치
        // 첫집 포함, 마지막집 제외 [0, n-2]
        // 첫집 제외, 마지막집 포함 [1, n-1]
        if (nums.length == 1) return nums[0];

        int case1 = robRange(nums, 0, nums.length - 2);
        int case2 = robRange(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
