package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 1, 2, 3, 1
        // dp[0] = 1
        // dp[1] = 2
        // dp[2] = dp[0] + nums[2] = 1 + 3
        // dp[3] = dp[1] + nums[3] = 2 + 1
        for (int i = 2; i < nums.length; i++) {
            // dp[i] = dp[i - 2] + nums[i];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
