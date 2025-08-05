package src.LeetCode.Array;

import java.util.*;

// https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // 현재 문자값이 다음 문자값보다 작으면 빼야함
        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            if (i + 1 < s.length() && current < map.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
