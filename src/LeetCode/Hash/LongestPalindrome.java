package src.LeetCode.Hash;

import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome/description/?envType=problem-list-v2&envId=greedy
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // greedy 로 풀면
        // 각 문자는 최대한 쌍으로 사용하는게 유리함
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean hasOdd = false;
        int result = 0;

        for (int count : map.values()) {
            result += (count / 2) * 2;
            if (count % 2 == 1) { // 홀수 개수는 가운데 하나만 놓을수 있음 ㅇㅂㅇ
                hasOdd = true;
            }
        }

        if (hasOdd) {
            result += 1;
        }


        return result;
    }
}
