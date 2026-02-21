package src.LeetCode.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-minimum-cost-array-permutation/
public class FindTheMinimumCostArrayPermutation {
    // 비트마스크 DP + 메모이제이션
    // 이미 쓴 숫자 -> 이걸 비트로 표현함
    // dp[mask][last] = mask 상태에서 마지막으로 쓴 숫자가 last 일때, 지금까지의 최소비용
    public int[] findPermutation(int[] nums) {
        int n = nums.length;

        // ex) n = 4 ==> mask == 0~15
        int[][] dp = new int[1 << n][n];

        // 초기화
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[1][0] = 0;

        int[][] parent = new int[1 << n][n];
        for (int[] row : parent) {
            Arrays.fill(row, -1);
        }

        /*
         * dp[mask | (1 << next)][next] = Math.min(
         *     dp[mask | (1 << next)][next],
         *     dp[mask][last] + Math.abs(next - nums[last])
         * )
         */

        for(int mask = 1; mask < (1 << n); mask++) {
            for(int last = 0; last < n ; last++) {
                if(dp[mask][last] == Integer.MAX_VALUE) {
                    continue; // 갱신되기 전이므로 패스
                }

                if (((mask >> last) & 1) == 0) { // last 가 실제로 mask 에 포함되어 있는지? (1이면 사용, 0이면 사용 안한거)
                    continue;
                }

                for(int next = 0; next < n; next++) {
                    if (((mask >> next) & 1) == 1) { // next 가 아직 안쓰인 경우만 체크
                        continue;
                    }

                    int newMask = mask | (1 << next); // 인덱스 추가
                    int newCost = dp[mask][last] + Math.abs(last - nums[next]);

                    if (newMask == (1 << n) - 1) { // 모든 숫자를 다 썼을 때 순환 비용 추가
                        newCost += Math.abs(next - nums[0]);
                    }

                    if (newCost <= dp[newMask][next]) {
                        dp[newMask][next] = newCost;
                        parent[newMask][next] = last;
                    }
                }
            }
        }

        // fullMask 상태에서 순환 비용으로 초기화
        int fullMask = (1 << n) - 1;
        for (int last = 0; last < n; last++) {
            dp[fullMask][last] = Math.abs(last - nums[0]);  // 순환 비용
        }

        // 뒤에서부터 채우기
        for (int mask = fullMask - 1; mask >= 1; mask--) {
            for (int last = 0; last < n; last++) {
                if (((mask >> last) & 1) == 0) continue;
                dp[mask][last] = Integer.MAX_VALUE;

                for (int next = 0; next < n; next++) {
                    if (((mask >> next) & 1) == 1) continue;
                    int newMask = mask | (1 << next);
                    int cost = Math.abs(last - nums[next]) + dp[newMask][next];
                    dp[mask][last] = Math.min(dp[mask][last], cost);
                }
            }
        }

        int[] result = new int[n];
        result[0] = 0;
        int mask = 1;
        int last = 0;

        for (int i = 1; i < n; i++) {
            int bestNext = -1;
            int bestCost = Integer.MAX_VALUE;

            for (int next = 0; next < n; next++) {
                if (((mask >> next) & 1) == 1) continue;
                int cost = Math.abs(last - nums[next]) + dp[mask | (1 << next)][next];
                if (cost < bestCost) {
                    bestCost = cost;
                    bestNext = next;
                }
            }

            result[i] = bestNext;
            mask |= (1 << bestNext);
            last = bestNext;
        }

        return result;
    }
}
