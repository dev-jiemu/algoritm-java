package src.LeetCode.SlidingWindow;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
public class LongestSubstringWithoutRepeatingCharacters {
    // 연속성이란게 abcdf, wsdteg 등 직전 문자와 다르면 됨
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            // left 위치 조정
            if (map.containsKey(key) && map.get(key) >= left) {
                // 현재 윈도우 안에 있는 중복만 처리
                left = map.get(key) + 1;
            }

            map.put(key, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
