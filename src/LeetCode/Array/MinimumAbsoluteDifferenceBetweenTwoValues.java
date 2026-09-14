package src.LeetCode.Array;

// 3880. Minimum Absolute Difference Between Two Values
// https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/
public class MinimumAbsoluteDifferenceBetweenTwoValues {
    public int minAbsoluteDifference(int[] nums) {
        int min = Integer.MAX_VALUE;

        int one = -1;
        int two = -1;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                continue;
            }

            if (nums[i] == 1) {
                one = i;
            } else  if (nums[i] == 2) {
                two = i;
            }

            if (one != -1 && two != -1){
                min = Math.min(min, Math.abs(one - two));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
