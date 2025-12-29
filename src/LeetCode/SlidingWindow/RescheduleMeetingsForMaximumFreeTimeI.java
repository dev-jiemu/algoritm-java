package src.LeetCode.SlidingWindow;

import java.util.Arrays;

// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/description/
public class RescheduleMeetingsForMaximumFreeTimeI {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[][] events = new int[n][2];

        for (int i = 0; i < n; i++) {
            events[i][0] = startTime[i];
            events[i][1] = endTime[i];
        }

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxFree = 0;
        int windowDuration = 0;

        // 초기 윈도우
        for (int i = 0; i < k && i < n; i++) {
            windowDuration += events[i][1] - events[i][0];
        }

        for (int i = 0; i + k <= n; i++) {
            int left = (i == 0) ? 0 : events[i - 1][1];
            int right = (i + k == n) ? eventTime : events[i + k][0];

            int free = (right - left) - windowDuration;
            maxFree = Math.max(maxFree, free);

            // 윈도우 슬라이드
            if (i + k < n) {
                windowDuration -= events[i][1] - events[i][0];
                windowDuration += events[i + k][1] - events[i + k][0];
            }
        }

        return maxFree;
    }
}
