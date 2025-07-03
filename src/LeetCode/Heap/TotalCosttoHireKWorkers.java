package src.LeetCode.Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/total-cost-to-hire-k-workers/?envType=study-plan-v2&envId=leetcode-75
public class TotalCosttoHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        long result = 0;

        int leftEnd = Math.min(candidates - 1, costs.length - 1);
        int rightStart = Math.max(costs.length - candidates, 0);

        // 범위가 겹칠수 있음
        if (leftEnd >= rightStart) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < costs.length; i++) {
                pq.add(costs[i]);
            }

            for (int i = 0; i < k; i++) {
                result += pq.poll();
            }

        } else {
            PriorityQueue<Integer> left = new PriorityQueue<>();
            PriorityQueue<Integer> right = new PriorityQueue<>();

            // 안 겹치는 경우: 두 힙 따로 채우기
            for (int i = 0; i <= leftEnd; i++) {
                left.add(costs[i]);
            }
            for (int i = rightStart; i < costs.length; i++) {
                right.add(costs[i]);
            }

            int leftPointer = leftEnd + 1;
            int rightPointer = rightStart - 1;
            for (int i = 0; i < k; i++) {
                int leftMin = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
                int rightMin = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

                if (leftMin <= rightMin) {
                    result += left.poll();  // left에서 제거
                    if (leftPointer < rightPointer) {
                        left.add(costs[leftPointer++]);
                    }
                } else {
                    result += right.poll(); // right에서 제거
                    if (leftPointer < rightPointer) {
                        right.add(costs[rightPointer--]);
                    }
                }
            }

        }

        return result;
    }
}
