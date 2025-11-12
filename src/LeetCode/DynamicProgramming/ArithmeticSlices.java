package src.LeetCode.DynamicProgramming;

// 주제는 슬라이딩 윈도우였는데... 풀다보니 DP가 최적...? ㅇㅂㅇ...
// https://leetcode.com/problems/arithmetic-slices/description/?envType=problem-list-v2&envId=sliding-window
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int count = 0;
        int current = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                current++; // 등차수열이 계속됨
                count += current;
            } else {
                current = 0;
            }
        }

        return count;
    }
}
