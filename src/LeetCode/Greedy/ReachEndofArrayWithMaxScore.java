package src.LeetCode.Greedy;

import java.util.List;

// https://leetcode.com/problems/reach-end-of-array-with-max-score/description/
public class ReachEndofArrayWithMaxScore {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long score = 0;
        int prevIndex = 0;

        for(int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(prevIndex) || i == n - 1) { // 이전 값보다 크거나 마지막 인덱스
                score += (long)(i - prevIndex) * nums.get(prevIndex);
                prevIndex = i;
            }
        }

        return score;
    }
}
