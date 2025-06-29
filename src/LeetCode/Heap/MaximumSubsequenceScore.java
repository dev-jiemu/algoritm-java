package src.LeetCode.Heap;


import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-subsequence-score/submissions/1680311668/?envType=study-plan-v2&envId=leetcode-75
public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]); // nums2 기준으로 내림차순 정렬 함

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for (int i = 0; i < nums1.length; i++) {
            int val1 = pairs[i][0];
            int val2 = pairs[i][1]; // nums2 최소값 후보 (그냥 최소값이라고 간주함)

            pq.offer(val1);
            sum += val1;

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                maxScore = Math.max(maxScore, sum * val2);
            }
        }

        return maxScore;
    }
}
