package src.LeetCode.Greedy;

import java.util.PriorityQueue;

// 1405. Longest Happy String
// https://leetcode.com/problems/longest-happy-string/description/
public class LongestHappyString {
    // 그리디인데 우선순위 큐를 활용하면 될듯
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0) {
            pq.offer(new int[]{a, 'a'});
        }
        if (b > 0) {
            pq.offer(new int[]{b, 'b'});
        }
        if (c > 0) {
            pq.offer(new int[]{c, 'c'});
        }

        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            int length = sb.length();

            // 같은 글자가 두개 이상이면 안됨
            if (length >= 2 && sb.charAt(length - 1) == first[1] && sb.charAt(length - 2) == first[1]) {
                if (pq.isEmpty()) {
                    break;
                }

                int[] second = pq.poll();
                sb.append((char) second[1]);
                second[0]--;
                if (second[0] > 0) {
                    pq.offer(second); // 다시 넣기
                }
                pq.offer(first); // 다시 넣기
            } else {
                sb.append((char) first[1]);
                first[0]--;
                if(first[0] > 0) {
                    pq.offer(first);
                }
            }
        }

        return sb.toString();
    }
}
