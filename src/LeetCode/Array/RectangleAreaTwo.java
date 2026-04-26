package src.LeetCode.Array;

import java.util.*;

// 850. Rectangle Area 2
// https://leetcode.com/problems/rectangle-area-ii/description/
public class RectangleAreaTwo {
    class Event implements Comparable<Event> {
        int x;
        int y1;
        int y2;
        int type; // 1이면 시작, -1이면 종료

        public Event(int x, int y1, int y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            // x 좌표 기준으로 정렬
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            // x가 같으면 type 기준 (종료를 먼저 처리하면 좋음)
            return Integer.compare(this.type, other.type);
        }
    }

    // TreeMap 은 y1 이 여러개 겹치면 에러가 발생함 - 중복을 안받아주니까
    // private TreeMap<Integer, Integer> activeYRanges = new TreeMap<>();
    // y 구간들이 직사각형으로 덮여있는지 추적해야함 - 리스트 형태로 관리하기
    private List<int[]> activeYRanges = new ArrayList<>();
    private static final int MOD = 1_000_000_007;

    public int rectangleArea(int[][] rectangles) {
        long result = 0;

        List<Event> events = new ArrayList<>();
        // 이벤트 생성
        for (int[] rect : rectangles) {
            events.add(new Event(rect[0], rect[1], rect[3], 1));  // 시작
            events.add(new Event(rect[2], rect[1], rect[3], -1)); // 종료
        }

        // x를 기준으로 정렬함
        Collections.sort(events);

        long prevX = 0;

        for (Event e : events) {
            // 이전 x부터 현재 x까지의 면적 계산
            long yLength = computeYLength();

            long width = (e.x - prevX) % MOD;  // 먼저 MOD
            long area = (width * (yLength % MOD)) % MOD;  // 각각 MOD 후 곱하기
            result = (result + area) % MOD;

            // 현재 이벤트 적용 (y구간 추가/제거)
            updateActiveYRanges(e);
            prevX = e.x;
        }

        return (int)result;
    }

    private long computeYLength() {
        if (activeYRanges.isEmpty()) return 0;

        // 정렬
        List<int[]> sorted = new ArrayList<>(activeYRanges);
        sorted.sort((a, b) -> a[0] - b[0]);

        long total = 0;
        int currentStart = sorted.get(0)[0];
        int currentEnd = sorted.get(0)[1];

        for (int i = 1; i < sorted.size(); i++) {
            int[] range = sorted.get(i);

            if (range[0] <= currentEnd) {
                // 겹침 - 병합
                currentEnd = Math.max(currentEnd, range[1]);
            } else {
                // 안 겹침 - 이전 구간 확정
                total += currentEnd - currentStart;
                currentStart = range[0];
                currentEnd = range[1];
            }
        }

        total += currentEnd - currentStart;
        return total;
    }

    private void updateActiveYRanges(Event e) {
        if (e.type == 1) {
            // 시작: 구간 추가
            activeYRanges.add(new int[]{e.y1, e.y2});
        } else {
            // 종료: 정확히 일치하는 구간 하나만 제거
            for (int i = 0; i < activeYRanges.size(); i++) {
                if (activeYRanges.get(i)[0] == e.y1 && activeYRanges.get(i)[1] == e.y2) {activeYRanges.remove(i);
                    break;
                }
            }
        }
    }
}


/*
1. 이벤트 수집
   - 각 직사각형의 왼쪽 세로선(시작)과 오른쪽 세로선(종료)를 이벤트로 저장
   - 이벤트: (x좌표, y1, y2, 타입:시작/종료)

2. x좌표 기준 정렬

3. Sweep 진행
   for (각 x좌표) {
       현재 활성화된 y구간들을 관리
       → 구간들을 병합하여 총 y축 길이 계산

       면적 += (다음x - 현재x) × y축길이
   }
 */