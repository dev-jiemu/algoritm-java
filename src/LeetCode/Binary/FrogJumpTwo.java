package src.LeetCode.Binary;

// 2498. Frog Jump II
// https://leetcode.com/problems/frog-jump-ii/description/
public class FrogJumpTwo {
    public int maxJump(int[] stones) {
        if (stones.length == 2) {
            return stones[1] - stones[0];
        }

        int result = 0;

        for(int i = 2; i < stones.length; i++) {
            result = Math.max(result, stones[i] - stones[i - 2]);
        }

        return result;
    }
}
