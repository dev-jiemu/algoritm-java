package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/count-days-without-meetings/
public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // 겹치는날 합치기
        List<int[]> merged = new ArrayList<>();

        for (int[] meeting : meetings) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < meeting[0]) {
                merged.add(meeting);
            } else {
                // 겹치면 끝나는 날짜 갱신
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }

        int busyDays = 0;
        for (int[] interval : merged) {
            busyDays += interval[1] - interval[0] + 1;
        }

        return days - busyDays;
    }
}
