package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-good-partitions/
public class CountTheNumberOfGoodPartitions {
    // hash
    // backtracking 을 처음에 생각했는데, 이렇게 하면 시간 복잡도가 너무 커져서 안됨
    public int numberOfGoodPartitions(int[] nums) {
        // Since the answer may be large, return it modulo 109 + 7
        final int MOD = 1_000_000_007;

        Map<Integer, Integer> lastPos = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            lastPos.put(nums[i], i); // hashmap 이니까 마지막 인덱스만 가지고 있게 됨
        }

        int maxRight = 0;
        int partition = 0;

        // i 위치까지 봤을 때, 지금까지 본 모든 숫자들의 마지막 위치 중 최댓값이 `maxRight`
        // maxRight == i 라면 지금까지 본 모든 숫자가 i 이하에서 끝남 = 나눠도 됨
        for (int i = 0; i < nums.length; i++) {
            maxRight = Math.max(maxRight, lastPos.get(nums[i]));
            if (i == maxRight) {
                partition++; // 파티션 종료
            }
        }

        // k개 파티션 = 2^(k-1) 가지 경우의 수 = 경계계산
        long result = 1;
        for (int i = 0; i < partition - 1; i++) {
            result = (result * 2) % MOD;
        }

        return (int) result;
    }
}
