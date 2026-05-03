package src.LeetCode.String;

// 3664. Two-Letter Card Game
// https://leetcode.com/problems/two-letter-card-game/
public class TwoLetterCardGame {
    // xx 패턴, x? 패턴, ?x 패턴 다 찾아야함
    public int score(String[] cards, char x) {
        int[] ox = new int[10];  // x? 패턴
        int[] xo = new int[10];  // ?x 패턴
        int oo = 0;  // xx 패턴
        int lr = 0;  // x?와 ?x의 총 개수

        // 카드 분류
        for (String c : cards) {
            if (c.charAt(0) == x && c.charAt(1) == x) {
                oo++;
            } else if (c.charAt(0) == x) {
                ox[c.charAt(1) - 'a']++;
                lr++;
            } else if (c.charAt(1) == x) {
                xo[c.charAt(0) - 'a']++;
                lr++;
            }
        }

        // xx 카드가 충분히 많으면
        if (oo >= lr) return lr;

        // 같은 패턴 내 최대 매칭 계산
        int cnt = lr - oo;
        int internal = helper(ox) + helper(xo);
        return Math.min(internal, cnt / 2) + oo;
    }

    private int helper(int[] cnt) {
        int sum = 0, max = 0;
        for (int c : cnt) {
            sum += c;
            max = Math.max(max, c);
        }
        if (sum < 2) return 0;
        return Math.min(sum / 2, sum - max); // sum - max : 가장 많은 그룹은 다른 것들과만 매칭 가능
    }
}
