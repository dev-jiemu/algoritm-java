package src.LeetCode.String;

// 3813. Vowel-Consonant Score
// https://leetcode.com/problems/vowel-consonant-score/
public class VowelConsonantScore {
    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >='a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) >= 0) {
                    v++;
                } else {
                    c++;
                }
            }
        }

        return c == 0 ? 0 : v / c;
    }
}
