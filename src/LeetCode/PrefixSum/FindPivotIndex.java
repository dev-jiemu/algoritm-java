package src.LeetCode.PrefixSum;

// https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75
public class FindPivotIndex {
    // 처음엔 투포인터 생각했는데 투포인터로 돌리면 중복 sum 되버림 ㅡ.,ㅡ...
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
