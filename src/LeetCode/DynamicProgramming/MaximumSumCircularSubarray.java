package src.LeetCode.DynamicProgramming;

public class MaximumSumCircularSubarray {
    // 카데인 알고리즘 : 원형 배열일때 최대 부분합
    // 전체 배열 합에서 최소 부분합을 빼면 됨
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums);

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 원형 카데인
        int minKadane = kadaneMin(nums);

        if (totalSum == minKadane) { // 모든 원소가 음수인 경우 예외 처리
            return maxKadane;
        }

        // 두 케이스 중 최대값 반환
        return Math.max(maxKadane, totalSum - minKadane);
    }

    // 기본 카데인 : max
    private int kadane(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // 원형 카데인 : min
    private int kadaneMin(int[] nums) {
        int minSoFar = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }
}
