package src.Programmers.FullSearch;

import java.util.*;

// 정확도에서 일부 반례가 나와서 참조함 :: 꼭 복습하기 ㅠㅠ
// Ref. https://school.programmers.co.kr/questions/52569
// Ref. https://galid1.tistory.com/507
public class Fatigue {
    public int solution(int k, int[][] dungeons) {
        Arrays.sort(dungeons, (o1, o2) -> Integer.compare(o1[0] - o1[1], o2[0] - o2[1]));

        int[][] dp = new int[dungeons.length + 1][k + 1];

        for (int i = 1; i <= dungeons.length; i++) {
            int minFatigue = dungeons[i - 1][0];
            int fatigueCost = dungeons[i - 1][1];

            for (int r = 1; r <= k; r++) {
                dp[i][r] = (minFatigue > r) ? dp[i - 1][r] : Math.max(dp[i - 1][r], 1 + dp[i - 1][r - fatigueCost]);
            }
        }

        return dp[dungeons.length][k];

    }

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int k = 80;

        Fatigue fatigue = new Fatigue();

        int result = fatigue.solution(k, dungeons);
        System.out.println("result : " + result);
    }

}
