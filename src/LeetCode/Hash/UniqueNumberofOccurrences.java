package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return new HashSet<>(map.values()).size() == map.size();
    }
}
