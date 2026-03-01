package src.LeetCode.Math;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/
public class FindTheCountOfNumbersWhichAreNotSpecial {
    // 에라토스테네스의 체
    // 2부터 탐색해서 소수가 아닌 숫자는 제거함
    // l이 4나 9같은 다른 숫자의 제곱수일 수 있어서 시작범위를 l로 잡으면 안됨ㅠ
    public int nonSpecialCount(int l, int r) {
        int maxRoot = (int) Math.sqrt(r);

        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[maxRoot + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= maxRoot; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxRoot; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int lo = (int) Math.ceil(Math.sqrt(l));
        int specialCount = 0;
        for (int i = lo; i <= maxRoot; i++) {
            if (isPrime[i]) specialCount++;
        }

        return r - l + 1 - specialCount;
    }
}
