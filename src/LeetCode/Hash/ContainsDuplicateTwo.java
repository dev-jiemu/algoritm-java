package src.LeetCode.Hash;

import java.util.HashMap;

// https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
public class ContainsDuplicateTwo {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int distance = i - map.get(nums[i]);
                if (distance <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
