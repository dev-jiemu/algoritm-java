package src.Programmers.Practice.Lv1;

import java.util.ArrayList;

// 유연근무제
// https://school.programmers.co.kr/learn/courses/30/lessons/388351
public class FlexibleWorking {

    public static void main(String[] args) {
        int[][] timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int[] schedules = new int[]{700, 800, 1100};
        int startday = 5;

        int result = new FlexibleWorking().solution(schedules, timelogs, startday);
        System.out.println("result : " + result);
    }

    // TODO : 정확도 개선 요망
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0; // 상품 받을 직원

        ArrayList<Integer> weekdayIndices = new ArrayList<>();
        int day = startday;

        for (int i = 0; i < 7; i++) {
            if (day >= 1 && day <= 5) {
                weekdayIndices.add(i); // i는 timelogs에서의 열 인덱스
            }

            day++;
            if (day > 7) day = 1; // 7을 넘어가면 다시 1로
        }

        System.out.println("Weekday indices: " + weekdayIndices);
        System.out.println("Size: " + weekdayIndices.size());

        for(int i = 0; i < schedules.length; i++) {
            int count = 0;
            int limit = schedules[i] + 10;

            for (int dayIndex : weekdayIndices) {
                if (timelogs[i][dayIndex] <= limit) {
                    count++;
                }
            }

            if (count == 5) {
                answer++;
            }
        }

        return answer;
    }
}
