package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/majority-element-ii/description/?envType=problem-list-v2&envId=counting
public class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int threshold = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
