package src.LeetCode.Stack;

// 1717. Maximum Score From Removing Substrings
// https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
public class MaximumScoreFromRemovingSubstrings {
    // x, y 중 큰거 먼저 제거 -> 그 뒤에 다른거 제거
    public int maximumGain(String s, int x, int y) {
        char high = x >= y ? 'a' : 'b';
        char low  = high == 'a' ? 'b' : 'a';
        int highScore = Math.max(x, y);
        int lowScore  = Math.min(x, y);

        int result = 0;

        StringBuilder sb1 = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == low && sb1.length() > 0 && sb1.charAt(sb1.length() - 1) == high) {
                sb1.deleteCharAt(sb1.length() - 1);
                result += highScore;
            } else {
                sb1.append(c);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < sb1.length(); i++) {
            char c = sb1.charAt(i);
            if (c == high && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == low) {
                sb2.deleteCharAt(sb2.length() - 1);
                result += lowScore;
            } else {
                sb2.append(c);
            }
        }

        return result;
    }
}
