package src.LeetCode.TwoPointers;

// https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindTheDuplicateNumber {
    // 토끼와 거북이 알고리즘...?
    // 서로 다른 속도로 움직이는 두 포인터(토끼·거북이)를 이용해 순환(사이클) 여부를 O(n) 시간·O(1) 공간으로 판별하는 방법
    public int findDuplicate(int[] nums) {
        // 배열이 정렬되어 있지 않음
        // 중복된 숫자가 어디서 나올지 모름
        int slow = nums[0]; // 1씩 움직임
        int fast = nums[0]; // 2씩 움직임

        do {
            slow = nums[slow];           // 1칸
            fast = nums[nums[fast]];     // 2칸
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
