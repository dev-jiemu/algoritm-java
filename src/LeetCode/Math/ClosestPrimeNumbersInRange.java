package src.LeetCode.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/closest-prime-numbers-in-range/
public class ClosestPrimeNumbersInRange {
    // 에라토스테네스의 체
    // https://namu.wiki/w/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98%20%EC%B2%B4
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 소수가 2개 미만이면 [-1, -1] 반환
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        // 가장 가까운 두 소수 찾기
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }
}
