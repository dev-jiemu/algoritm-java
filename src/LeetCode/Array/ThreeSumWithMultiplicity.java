package src.LeetCode.Array;

// 923. 3Sum With Multiplicity
// https://leetcode.com/problems/3sum-with-multiplicity/description/
public class ThreeSumWithMultiplicity {
    // 제약조건 사이즈가 크지 않아서 브루트 포스로 해도 되는듯
    public int threeSumMulti(int[] arr, int target) {
        final int MOD = 1_000_000_007;
        long[] count = new long[101];

        for (int x : arr) {
            count[x]++;
        }

        long ans = 0;
        for (int a = 0; a <= 100; a++) {
            for (int b = a; b <= 100; b++) {
                int c = target - a - b;
                if (c < b || c > 100) {
                    continue;
                }

                if (a == b && b == c) {
                    // 세 값이 모두 같음 : count[a]개 중 3개 뽑기
                    ans += count[a] * (count[a] - 1) * (count[a] - 2) / 6;
                } else if (a == b) {
                    // a == b < c : count[a]개 중 2개 뽑고, count[c]개 중 1개
                    ans += count[a] * (count[a] - 1) / 2 * count[c];
                } else if (b == c) {
                    // a < b == c : count[a]개 중 1개, count[b]개 중 2개 뽑기
                    ans += count[a] * count[b] * (count[b] - 1) / 2;
                } else {
                    // a < b < c : 모두 다름
                    ans += count[a] * count[b] * count[c];
                }

                ans %= MOD;
            }
        }

        return (int) ans;
    }
}
