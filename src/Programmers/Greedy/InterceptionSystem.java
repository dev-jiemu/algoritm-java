package src.Programmers.Greedy;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=java
public class InterceptionSystem {
    /*
    1. targets를 끝점(targets[1]) 기준 오름차순 정렬
    2. bomb = targets[0][1]  (첫 선분의 끝점)
    3. count = 1
    4. 탐색하기
       - targets[i][0] >= bomb 이면 새 포탄 발급하기, 그리고 bomb 위치는 targets[i][1] 으로 변경

    포탄의 처음, 끝 위치를 다 파악해야 하는건줄 알았는데 그냥 끝점만 판단해도 상관없었음 ㅇㅇ
     */
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int bomb = targets[0][1]; // 끝점만 봐도 됨
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= bomb) {
                answer++;
                bomb = targets[i][1];
            }
        }

        return answer;
    }
}
