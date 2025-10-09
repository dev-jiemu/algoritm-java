package src.LeetCode.DivideAndConquer;

// https://leetcode.com/problems/longest-nice-substring/description/?envType=problem-list-v2&envId=divide-and-conquer
public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        return divideAndConquer(s);
    }

    // Nice 하지 않는 문자열 기준으로 계속 쪼개면 됨
    private String divideAndConquer(String s) {
        if (s.length() < 2) return "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char pair = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);

            if (s.indexOf(pair) == -1) { // 없으면 분할
                String left = divideAndConquer(s.substring(0, i));
                String right = divideAndConquer(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        // 모든 문자가 쌍이 있으면 전체 문자열이 nice
        return s;
    }
}
