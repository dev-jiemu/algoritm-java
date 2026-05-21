package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

// 57. Insert Interval
// https://leetcode.com/problems/insert-interval/description/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 안겹치는건 넣음
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // 나머지
        while(i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
