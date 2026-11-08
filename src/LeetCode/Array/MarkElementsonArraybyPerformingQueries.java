package src.LeetCode.Array;

import java.util.PriorityQueue;

// 3080. Mark Elements on Array by Performing Queries
// https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/
public class MarkElementsonArraybyPerformingQueries {
    // 우선순위 큐가 직관적이긴 한데 포인터로도 풀수는 있을듯함
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // 표시 관리
        boolean[] marked = new boolean[n];

        // 값 오름차순, 인덱스 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            pq.offer(new int[]{nums[i], i});
        }

        long[] answer = new long[m];

        for(int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if(!marked[index]) {
                marked[index] = true;
                sum -= nums[index];
            }

            while(k > 0 && !pq.isEmpty()) {
                int[] cur = pq.poll();
                if (marked[cur[1]]) {
                    continue; // 이미 마크된건 패스
                }
                marked[cur[1]] = true;
                sum -= cur[0];
                k--;
            }

            answer[i] = sum;
        }

        return answer;
    }
}
