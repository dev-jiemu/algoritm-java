package src.LeetCode.Tree;

import java.util.*;

// https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/description/
// segment tree ref. https://velog.io/@kimdukbae/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%84%B8%EA%B7%B8%EB%A8%BC%ED%8A%B8-%ED%8A%B8%EB%A6%AC-Segment-Tree
public class MaximumAreaRectangleWithPointConstraintsTwo {
    // SegmentTree 를 활용해서 최소값 추적하기
    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
            Arrays.fill(tree, 0);
        }

        void update(int idx, int start, int end, int target, int val) {
            if (start == end) {
                tree[idx] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (target <= mid)
                update(idx * 2, start, mid, target, val);
            else
                update(idx * 2 + 1, mid + 1, end, target, val);

            tree[idx] = Math.max(tree[idx * 2], tree[idx * 2 + 1]);
        }

        int query(int idx, int start, int end, int left, int right) {
            if (right < start || end < left) return 0;
            if (left <= start && end <= right) return tree[idx];

            int mid = (start + end) / 2;
            return Math.max(
                    query(idx * 2, start, mid, left, right),
                    query(idx * 2 + 1, mid + 1, end, left, right)
            );
        }
    }

    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        // x축은 정렬 한번 하고 오른쪽으로 순서대로 스윕할거임
        // y축은 세그먼트 트리로 안에 포함되어있는지 아닌지를 체크할거임

        // 일단 점배열 먼저 생성
        int n = xCoord.length;

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = xCoord[i];
            points[i][1] = yCoord[i];
        }

        // x축 정렬
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // x 값 같은거 묶기
        TreeMap<Integer, List<Integer>> xToYs = new TreeMap<>();
        for (int[] p : points) {
            xToYs.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        // y좌표의 인덱스를 세그먼트 트리로 관리함
        int[] ys = Arrays.stream(points)
                .mapToInt(p -> p[1])
                .distinct()
                .sorted()
                .toArray();

        // 원래 y값 → 압축 인덱스 매핑
        Map<Integer, Integer> yIndex = new HashMap<>();
        for (int i = 0; i < ys.length; i++) {
            yIndex.put(ys[i], i);
        }

        SegmentTree st = new SegmentTree(ys.length);

        long maxArea = -1;
        Map<String, Integer> pairToX = new HashMap<>(); // 이전 값 확인용

        for (Map.Entry<Integer, List<Integer>> entry : xToYs.entrySet()) {
            int curX = entry.getKey();
            List<Integer> yList = entry.getValue();

            for (int i = 0; i < yList.size() - 1; i++) {
                int y1 = yList.get(i);
                int y2 = yList.get(i + 1); // 바로 다음 y만 봄 (인접한것만 보기)
                String pair = y1 + "," + y2;

                if (pairToX.containsKey(pair)) {
                    int prevX = pairToX.get(pair);

                    // 세그먼트 트리로 y1~y2 구간 내부 점 검증
                    int minYIdx = yIndex.get(y1);
                    int maxYIdx = yIndex.get(y2);

                    int maxXInRange = st.query(1, 0, ys.length-1, minYIdx, maxYIdx);
                    if (maxXInRange <= prevX) {
                        maxArea = Math.max(maxArea, (long)(curX - prevX) * (y2 - y1));
                    }
                }

                pairToX.put(pair, curX);
            }

            for (int y : yList) {
                st.update(1, 0, ys.length - 1, yIndex.get(y), curX);
            }
        }

        return maxArea;
    }
}