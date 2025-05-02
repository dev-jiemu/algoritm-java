package src.Programmers.Practice.Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 서버 증설 횟수
// https://school.programmers.co.kr/learn/courses/30/lessons/389479
public class ServerExpansionCounter {

    public static void main(String[] args) {
        int[] players = new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        int m = 5;
        int k = 1;

        int result = solution(players, m, k);
        System.out.println(result);
    }

    // m = 서버 증설에 필요한 인원수
    // k = 서버 생성하면 유지하는 시간
    public static int solution(int[] players, int m, int k) {
        int answer = 0; // 최소 서버 증설횟수

        // 0시부터 23시까지 니까 총 24번을 돌건데
        // 서버 k 만큼 유지해야하니까 i-- 저장해두는것도 더 필요할것 같은데
        // for - queue ?
        Queue<Integer> queue = new LinkedList<>(); // 종료시간을 저장해야 할듯

        for (int time = 0; time < players.length; time++) {
            int need = players[time] / m; // 필요한거

            while(!queue.isEmpty() && queue.peek() <= time) {
                queue.poll();
            }

            int current = queue.size();
            if (current < need) {
                int add = need - current;
                answer += add;
                for(int i = 0; i < add; i++) {
                    queue.add(time + k);
                }
            }

        }

        return answer;
    }

}
