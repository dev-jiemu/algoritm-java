package src.LeetCode.Interval;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=leetcode-75
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {

        // 시작점 기준으로 일단 정렬해봄
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int result = 1;
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= currentEnd) { // 시작점 & 끝점 체크
                currentEnd = Math.min(points[i][1], currentEnd);
            } else {
                result++;
                currentEnd = points[i][1];
            }
        }

        return result;
    }
}
