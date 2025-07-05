package src.LeetCode.Bits;

// https://leetcode.com/problems/single-number/submissions/1687227541/?envType=study-plan-v2&envId=leetcode-75
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
