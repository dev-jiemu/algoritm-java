package src.LeetCode.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/ugly-number-ii/description/?envType=problem-list-v2&envId=heap-priority-queue
public class UglyNumberTwo {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        pq.offer(1L);
        seen.add(1L);

        long result = 1;

        for (int i = 0; i < n; i++) {
            result = pq.poll(); // i + 1 번째임

            int[] multipliers = {2, 3, 5};
            for (int mult : multipliers) {
                long next = result * mult;
                if (!seen.contains(next)) {
                    seen.add(next);
                    pq.offer(next);
                }
            }
        }

        return (int) result;
    }
}
