package src.Books.CheetSheetWithLeetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramsInaString {
    // 애너그램 = 완전 순열
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();


        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int validCount = 0;
        int windowSize = p.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    validCount++;
                }
            }

            // 윈도우 크기 조절
            while (right - left == windowSize) {
                // anagram 체크
                if (validCount == map.size()) {
                    result.add(left);
                }

                // 왼쪽 문자 제거
                char leftChar = s.charAt(left);
                left++;

                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        validCount--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return result;
    }
}
