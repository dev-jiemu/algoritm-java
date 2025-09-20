package src.LeetCode.TwoPointers;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=string&
public class LongestSubstringWithoutRepeatingCharacters {

    // Two pointer + hash
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // 과거에 있는 문자열 저장하는 맵

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) { // 중복된 문자가 현재 윈도우 안에 있는지 확인해야함
                left = map.get(ch) + 1;
            }

            map.put(ch, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
