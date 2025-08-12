package src.LeetCode.Array;

// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return maxReach >= nums.length - 1;
    }
}
