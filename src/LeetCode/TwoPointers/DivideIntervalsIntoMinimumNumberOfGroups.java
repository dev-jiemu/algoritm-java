package src.LeetCode.TwoPointers;

import java.util.Arrays;

// 2406. Divide Intervals Into Minimum Number of Groups
// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/
public class DivideIntervalsIntoMinimumNumberOfGroups {
    // intervals 배열 자체를 start 기준으로 정렬하고 하려고 했더니 queue 를 어차피 써야하넹...;ㅅ;
    // start, end 둘이 나눠서 정렬하는것도 깔끔하고 괜찮을듯 ㅇㅂㅇ
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        // start, end 따로 나눔
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int result = 0;
        int j = 0; // right pointer
        for (int i = 0; i < n; i++) {
            if (starts[i] > ends[j]) {
                j++;
            } else {
                result++;
            }
        }

        return result;
    }
}
