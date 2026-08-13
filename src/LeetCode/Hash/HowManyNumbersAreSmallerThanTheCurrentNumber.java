package src.LeetCode.Hash;

// 1365. How Many Numbers Are Smaller Than the Current Number
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        // 해시로 해도 되는데 문제에서 0 ~ 100까지래서 배열로도 될듯
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        // 누적합 적용 ㅇㅂㅇ
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }
}
