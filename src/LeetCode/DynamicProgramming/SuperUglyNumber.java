package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/super-ugly-number/?envType=problem-list-v2&envId=dynamic-programming
public class SuperUglyNumber {
    // 주어진 primes 가지고 만드는 약수 배열
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int[] pointer = new int[primes.length];

        for(int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                long candidate = (long)dp[pointer[j]] * primes[j];
                min = Math.min(min, candidate);
            }

            dp[i] = (int)min;

            // 중복제거
            // 포인터 하나씩 이동
            for (int j = 0; j < primes.length; j++) {
                if ((long)dp[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }
        }

        return dp[n-1];
    }
}
