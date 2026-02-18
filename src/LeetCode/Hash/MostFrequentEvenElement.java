package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-frequent-even-element/
public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : nums) {
            if(num % 2 == 0) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        if (count.isEmpty()) return -1;

        int result = -1;
        int maxFreq = 0;

        // 동률일때 가장 작은 값 찾기
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq || (freq == maxFreq && num < result)) {
                result = num;
                maxFreq = freq;
            }
        }

        return result;
    }
}
