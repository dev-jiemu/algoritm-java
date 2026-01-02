package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/maximum-score-from-grid-operations/description/
public class MaximumScoreFromGridOperations {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        // prefix[j][i] = j번째 열의 0~(i-1)행까지의 합
        long[][] prefix = new long[n][n + 1];

        // prevPick[i] = 이전 열을 (i-1)행까지 칠하고 점수를 받은 경우의 최대값
        long[] prevPick = new long[n + 1];

        // prevSkip[i] = 이전 열을 건너뛰고, 그 전 열을 (i-1)행까지 칠한 경우의 최대값
        long[] prevSkip = new long[n + 1];

        // prefix sum
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                prefix[j][i + 1] = prefix[j][i] + grid[i][j];
            }
        }

        for (int j = 1; j < n; j++) {
            long[] currPick = new long[n + 1];
            long[] currSkip = new long[n + 1];

            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {

                    if (curr > prev) { // 현재 열이 더 깊음 → 이전 열의 [prev, curr) 구간에서 점수
                        long score = prefix[j - 1][curr] - prefix[j - 1][prev];
                        currPick[curr] = Math.max(currPick[curr], prevSkip[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevSkip[prev] + score);
                    } else { // 이전 열이 더 깊거나 같음 → 현재 열의 [curr, prev) 구간에서 점수
                        long score = prefix[j][prev] - prefix[j][curr];
                        currPick[curr] = Math.max(currPick[curr], prevPick[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevPick[prev]);
                    }
                }
            }

            prevPick = currPick;
            prevSkip = currSkip;
        }

        // 최종 = prevPick의 최대값
        long answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, prevPick[i]);
        }

        return answer;
    }
}
