package src.LeetCode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/description/?envType=problem-list-v2&envId=heap-priority-queue
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            int result = Math.abs(stone1 - stone2);
            if (result > 0) {
                pq.offer(result);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
