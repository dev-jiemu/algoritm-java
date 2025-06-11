package src.LeetCode.SlidingWindow;

import java.util.HashMap;

// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                int needCnt = need.get(c);
                int windowCnt = window.get(c);
                if (windowCnt == needCnt) {
                    valid++;
                }
            }

            // 왼쪽 윈도우 축소 여부 판별
            while(right - left >= s1.length()) {
                if(valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    int needCnt = need.get(d);
                    int windowCnt = window.get(d);
                    if (windowCnt == needCnt) {
                        valid--;
                    }
                    window.put(d, windowCnt - 1);
                }
            }
        }

        return false;
    }
}
