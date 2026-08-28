package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// 2190. Most Frequent Number Following Key In an Array
// https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/description/
public class MostFrequentNumberFollowingKeyInanArray {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0) + 1);
            }
        }

        int result = -1;
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
