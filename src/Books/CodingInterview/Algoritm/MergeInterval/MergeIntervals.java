package src.Books.CodingInterview.Algoritm.MergeInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    // 시작과 끝점 기준으로 비교해서 스택 쌓는 방식으로

    // 실행시간 O(nlogn), 스택 공간 O(n)
    public static void mergeIntervals(Interval[] intervals) {
        // 정렬
        Arrays.sort(intervals, new Comparator<Interval>(){ // 오름차순 정렬
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Stack<Interval> stackOfIntervals = new Stack<>();

        for (Interval interval : intervals) {
            if (stackOfIntervals.empty() || interval.start > stackOfIntervals.peek().end) { // 구간이 안겹치면 넣음
                stackOfIntervals.push(interval);
            }

            // 끝점 비교해서 크면 넣음
            if (stackOfIntervals.peek().end < interval.end) {
                stackOfIntervals.peek().end = interval.end;
            }
        }

        while(!stackOfIntervals.empty()) {
            System.out.println(stackOfIntervals.pop() + " ");
        }
    }

    // 정렬을 내림차순으로 해보면
    // 스택 안쓰고 비교도 가능함ㅇㅇ
    public static void mergeIntervalsOptimized(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i2.start - i1.start;
            }
        });

        int index = 0;

        for (int i = 0; i < intervals.length; i++) {
            if(index != 0 && intervals[index - 1].start <= intervals[i].end) {
                intervals[index - 1].end = Math.max(intervals[index - 1].end, intervals[i].end);
                intervals[index - 1].start = Math.min(intervals[index - 1].start, intervals[i].start);
                index--;
            } else {
                intervals[index] = intervals[i];
            }

            index++;
        }

        for(int i = 0; i < index; i++) {
            System.out.println(intervals[i] + " ");
        }

    }
}


