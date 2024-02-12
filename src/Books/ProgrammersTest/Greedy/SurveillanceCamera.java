package src.Books.ProgrammersTest.Greedy;

import java.util.*;

public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int answer = 0;

        // 끝지점 기준으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int last = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if (last >= route[0] && last <= route[1]) { // 직전에 설치한 단속 카메라가 경로에 포함되어있으면 패스
                continue;
            }

            last = route[1];
            answer++;

        }

        return answer;
    }
}
