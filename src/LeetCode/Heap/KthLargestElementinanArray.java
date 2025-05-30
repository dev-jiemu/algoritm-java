package src.LeetCode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=leetcode-75
public class KthLargestElementinanArray {

    // 그냥 정렬하고 길이에서 k만큼 빼면 되지않나..?
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 근데 주제가 heap 이니까 PriorityQueue 도 연습
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

}
