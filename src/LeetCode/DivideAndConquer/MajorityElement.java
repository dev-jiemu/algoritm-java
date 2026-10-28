package src.LeetCode.DivideAndConquer;

// 169. Majority Element
// https://leetcode.com/problems/majority-element/description/
public class MajorityElement {
    // 과반수 원소는 반드시 존재하고, 그 개수는 n/2보다 크다.
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) { // 카운트가 없으면 문자로 고정
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
