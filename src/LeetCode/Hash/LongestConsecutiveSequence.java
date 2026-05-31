package src.LeetCode.Hash;

import java.util.HashSet;

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    // 문제 조건이 O(n) 이라서 정렬은 하면 안됨
    // set에 넣고 이전값이 있으면 연속된 값으로 이해하면 될듯
    public int longestConsecutive(int[] nums) {
        int result = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for(int x : set) {
            // x가 시작점이면 세는거임
            if(!set.contains(x - 1)) {
                int current = x;
                int count = 1;
                while(set.contains(current+1)) {
                    current++;
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
