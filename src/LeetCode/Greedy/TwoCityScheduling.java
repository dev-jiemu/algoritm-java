package src.LeetCode.Greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        // B - A 기준으로 오름차순으로 정렬함 -> 반절은 B로 보내고, 반절은 A로 보냄
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        int total = 0;

        // 앞에 계산
        // 2 * n == costs.length
        // B-A가 작은 앞 n명 = B로 보냄
        int n = costs.length / 2;
        for(int i = 0; i < n; i++) {
            total += costs[i][1];
        }

        for(int j = n; j < n * 2; j++) {
            total += costs[j][0];
        }

        return total;
    }
}
