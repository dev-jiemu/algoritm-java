package src.LeetCode.Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
public class SmallestInfiniteSet {
    // num = 1 ~ 1000
    // 문제 상으로 무한한 양의 정수 집합이 있다고 '가정' 하자고 하긴 했는데 시작할때 num 범위까지 안넣어도 됨
    private PriorityQueue<Integer> pq = null;
    // 없는데 있는척 대신 해줄 친구임
    private int smallestMissing = 1; // 1부터 시작

    public SmallestInfiniteSet() {
        this.pq = new PriorityQueue<>();
    }

    public int popSmallest() {
        if(!pq.isEmpty()) {
            return pq.poll();
        }

        return smallestMissing++;
    }

    public void addBack(int num) {
        if (num < smallestMissing && !pq.contains(num)) {
            pq.offer(num);
        }
    }
}
