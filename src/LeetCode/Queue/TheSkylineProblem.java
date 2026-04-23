package src.LeetCode.Queue;

import java.util.*;

// 218. The Skyline Problem
// https://leetcode.com/problems/the-skyline-problem/description/
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        for(int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            // 시작점, 끝점 저장 (구분하려고 - 붙임)
            events.add(new int[]{left, -height});
            events.add(new int[]{right, height});
        }

        // x 기준으로 정렬
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // x 좌표 오름차순
            }
            return a[1] - b[1];  // 같은 x면 높이 비교
        });

        // 큰값 우선순위
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        // 최대 높이 판단용
        int prevMax = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) { // 시작점
                pq.add(-h);
            } else {
                pq.remove(h);
            }

            int currentMax = pq.peek();
            if (prevMax != currentMax) {
                result.add(Arrays.asList(x, currentMax));
                prevMax = currentMax;
            }
        }

        return result;
    }
}

/*
 * 우선순위 Queue 말고 Tree Map 으로 하면, Red-Black Tree 로 구현되어 있어서 더 빠름
 * 애당초 처음부터 정렬되어 있기 때문임
 *
 * TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
 * map.put(0, 1);
 *
 * 생략
 *
 * else
 * int counmt = map.get(h);
 * if (count == 1)
 *  map.remove(h);
 * else
 *  map.put(h, count - 1); // 같은 높이가 여러개일수 있으니까 1개 빼기
 *
 * int currentMax = map.firstKey();  // 최댓값 (reverseOrder라서 firstKey)
 * if (prevMax != currentMax) {
 *  result.add(Arrays.asList(x, currentMax));
 *  prevMax = currentMax;
 * }
 */
