package src.LeetCode.Array;

// https://leetcode.com/problems/global-and-local-inversions/
public class GlobalAndLocalInversions {
    // global >= local
    public boolean isIdealPermutation(int[] nums) {
        // 0 ~ (n-1)
        // 제자리 체크해서 2 이상 떨어지면 반드시 거리 2이상의 역전이 발생함
        for(int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }
}
