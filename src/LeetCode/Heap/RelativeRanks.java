package src.LeetCode.Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/relative-ranks/description/?envType=problem-list-v2&envId=heap-priority-queue
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // (점수, 원래 인덱스)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i});
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int idx = current[1];

            if (rank == 1) {
                result[idx] = "Gold Medal";
            } else if (rank == 2) {
                result[idx] = "Silver Medal";
            } else if (rank == 3) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
