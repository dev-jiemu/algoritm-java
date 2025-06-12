package src.LeetCode.Interval;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/?envType=study-plan-v2&envId=leetcode-75
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 끝점 기준으로 정렬
        Arrays.sort(intervals, (a, b)->  a[1] - b[1]);

        int removeCount = 0;
        int currrentEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < currrentEnd){ // 끝점과 겹치면 제거함
                removeCount++;
            } else {
                currrentEnd = intervals[i][1];
            }
        }

        return removeCount;
    }
}
