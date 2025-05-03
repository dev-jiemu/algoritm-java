package src.Books.CheetSheetWithLeetCode.SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    // TODO: debug
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        // 오른쪽으로 진행
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == need.get(c)) {
                    valid++; // 글자가 같으면 이동
                }
            }
        }

        // 왼쪽 윈도우 축소 여부 결정
        while(valid == need.size()) {
            if (right - left < len) {
                start = left;
                len = right - left;
            }

            char d = s.charAt(left);
            left++;

            if(need.containsKey(d)) {
                if(window.get(d) == need.get(d)) {
                    valid--;
                }
                window.remove(d);
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
