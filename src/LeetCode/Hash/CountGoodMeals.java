package src.LeetCode.Hash;

import java.util.HashMap;

// https://leetcode.com/problems/count-good-meals/description/
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        // 1 << k 비트연산
        // 1 << 1 == 2
        // 1 << 2 == 4
        // 1 << 3 == 8
        // return the number of different good meals you can make from this list modulo 1^9 + 7
        int MOD = 1000000007;
        long count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : deliciousness) {
            // 0 <= deliciousness[i] <= 2^20
            for(int k = 0; k <= 21; k++) {
                int target = (1 << k) - num;
                count = (count + map.getOrDefault(target, 0)) % MOD;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return (int) count;
    }
}
