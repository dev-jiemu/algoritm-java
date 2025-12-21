package src.LeetCode.Math;

// https://leetcode.com/problems/sum-game/description/
public class SumGame {
    public boolean sumGame(String num) {
        // 홀수면 alice 가 무족건 이김
        // 짝수면 2 * (s1 - s2) !== 9 * (cnt2 - cnt1)
        int n = num.length();

        // 이건 ? 개수
        int cnt1 = 0;
        int cnt2 = 0;

        // 절반 숫자 합
        int s1 = 0;
        int s2 = 0;

        // 전반부 처리
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                cnt1++;
            } else {
                s1 += num.charAt(i) - '0';
            }
        }

        // 후반부 처리
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                cnt2++;
            } else {
                s2 += num.charAt(i) - '0';
            }
        }

        return (cnt1 + cnt2) % 2 == 1 || 2 * (s1 - s2) != 9 * (cnt2 - cnt1);
    }

    // 또다른 greedy 접근 법인데, 그냥 중간 수치인 4.5로 일괄 적용해서 계산하는것도 방법임
    // for claude
    /*
    public boolean sumGame(String num) {
        double balance = 0;
        int n = num.length();

        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                // '?'는 평균적으로 4.5의 값을 가진다고 가정 (Greedy)
                balance += (i < n/2 ? 1 : -1) * 4.5;
            } else {
                balance += (i < n/2 ? 1 : -1) * (num.charAt(i) - '0');
            }
        }

        return balance != 0;
    }
     */
}
