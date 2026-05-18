package src.LeetCode.Math;

// 553. Optimal Division
// https://leetcode.com/problems/optimal-division/
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return String.valueOf(nums[0]);
        }

        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");

        // 분모를 작게하면 커짐
        for (int i = 1; i < n; i++) {
            sb.append(nums[i]);
            if (i < n - 1) {
                sb.append("/");
            }
        }

        sb.append(")");
        return sb.toString();
    }
}
