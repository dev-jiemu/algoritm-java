package src.LeetCode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

// 974. Subarray Sums Divisible by K
// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;

        // 부분합 배열 먼저 구하기
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        // k로 나눠서 남은 나머지를 배열에 담기
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            // 음수보정
            // 자바는 % 할때 음수 나오면 음수 뱉는다고...? ㅇㅂㅇ...
            int remainder = ((prefix[i] % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        // 그룹 크기가 c개면, 그 안에서 2개 뽑는 조합 수는 c * (c-1) / 2
        for (int count : map.values()) {
            result += count * (count - 1) / 2;
        }

        return result;
    }
}
