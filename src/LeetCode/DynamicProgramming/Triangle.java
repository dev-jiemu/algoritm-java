package src.LeetCode.DynamicProgramming;

import java.util.List;

// https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=top-interview-150
public class Triangle {
    // 0번째 행의 i번째 원소에서는 다음 행의 i 또는 i+1 로만 이동 가능
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int [][] dp = new int[n][];
        for(int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int current = triangle.get(i).get(j);

                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + current; // 위에서만 옴
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + current; // 왼쪽 위에서만 옴
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + current;
                }
            }
        }

        int result = dp[n-1][0];
        for (int j = 1; j < dp[n-1].length; j++) {
            result = Math.min(result, dp[n-1][j]);
        }

        return result;
    }
}
