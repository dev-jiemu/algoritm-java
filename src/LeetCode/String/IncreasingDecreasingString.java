package src.LeetCode.String;

// 1370. Increasing Decreasing String
// https://leetcode.com/problems/increasing-decreasing-string/
public class IncreasingDecreasingString {
    public String sortString(String s) {
        // 소문자만 있다고 하니까 ㅇㅂㅇ
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // 오름차순 -> 내림차순
        while(sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char) ('a' + i));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    sb.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }

        return sb.toString();
    }
}
