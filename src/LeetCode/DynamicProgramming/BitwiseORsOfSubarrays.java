package src.LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

// 898. Bitwise ORs of Subarrays
// https://leetcode.com/problems/bitwise-ors-of-subarrays/description/
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);

            // OR 연산하면 쉽게 구해짐 ㅇㅂㅇ
            for(int prev : current) {
                next.add(prev | num);
            }

            current = next;
            result.addAll(current); // 모든 결과 다 누적시킴
        }

        return result.size();
    }
}
