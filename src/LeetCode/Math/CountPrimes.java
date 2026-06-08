package src.LeetCode.Math;

import java.util.Arrays;

// 204. Count Primes
// https://leetcode.com/problems/count-primes/description/
public class CountPrimes {
    // 소수 개수 찾기
    public int countPrimes(int n) {
        int result = 0;

        if (n == 0 || n == 1) {
            return result;
        }

        // 에라노스테라스의 체 ㅇㅂㅇ
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                result++;
                for (long j = (long) i * i; j < n; j += i) {
                    isPrimes[(int) j] = false;
                }
            }
        }

        return result;
    }
}
