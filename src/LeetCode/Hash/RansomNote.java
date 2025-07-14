package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magCount = new HashMap<>();

        for(char c : magazine.toCharArray()) {
            magCount.put(c, magCount.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (magCount.containsKey(c) && magCount.get(c) > 0) {
                magCount.put(c, magCount.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
