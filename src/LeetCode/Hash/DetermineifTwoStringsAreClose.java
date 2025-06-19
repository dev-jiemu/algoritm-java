package src.LeetCode.Hash;

import java.util.*;

// https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
public class DetermineifTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        // keyset이 다르고 배열 크기도 서로 다름 = false
        // keyset이 같긴 한데 배열 count도 같음 = true

        HashMap<Character, Integer> word1Map = new HashMap<>();
        HashMap<Character, Integer> word2Map = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
            word1Map.put(word1.charAt(i), word1Map.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for(int j = 0; j < word2.length(); j++) {
            word2Map.put(word2.charAt(j), word2Map.getOrDefault(word1.charAt(j), 0) + 1);
        }

        if (word1Map.keySet().equals(word2Map.keySet())) {
            List<Integer> values1 = new ArrayList<>(word1Map.values());
            List<Integer> values2 = new ArrayList<>(word2Map.values());

            Collections.sort(values1);
            Collections.sort(values2);

            return values1.equals(values2);
        }

        // word1Map.keySet() != word2Map.keySet()
        return false;
    }
}
