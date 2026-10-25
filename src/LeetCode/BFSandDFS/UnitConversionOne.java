package src.LeetCode.BFSandDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 3528. Unit Conversion I
// https://leetcode.com/problems/unit-conversion-i/
public class UnitConversionOne {
    public int[] baseUnitConversions(int[][] conversions) {
        int MOD = 1_000_000_007;
        int n = conversions.length + 1;

        // graph[source]
        // 단뱡향 그래프라서 source 만 만들면 됨
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] conv : conversions) {
            graph[conv[0]].add(new int[]{conv[1], conv[2]});
        }

        int[] result = new int[n];
        result[0] = 1;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int current  = queue.poll();
            for(int[] edge : graph[current]) {
                int next = edge[0];
                int factor = edge[1];
                result[next] = (int) ((long) result[current] * factor % MOD);
                queue.offer(next);
            }
        }

        return result;
    }
}
