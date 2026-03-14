package src.LeetCode.Array;

// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
// 문제 제한 자체가 크기가 작아서 브루트 포스로도 가능 ㅇㅂㅇ...
// 근데 좀 크면 정렬 + 이진탐색이 낫지 않을까?
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }

            if (count == i) {
                return count;
            }
        }

        return -1;
    }
}
