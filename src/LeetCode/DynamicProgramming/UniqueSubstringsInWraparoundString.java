package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
// 처음엔 hashmap + backtracking 생각했는데 O^2 라서 효율이 좋지 않음.... 중복계산의 여지도 있음
// 같은 문자로 끝나는 부분 문자열 중 가장 긴 것만 저장하면 되서 DP로 처리
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] dp = new int[26]; // a to z
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && isConsecutive(s.charAt(i - 1), s.charAt(i))) {
                length++;
            } else {
                length = 1;
            }

            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], length);
        }

        int result = 0;
        for (int len : dp) {
            result += len;
        }

        return result;
    }

    private boolean isConsecutive(char prev, char curr) {
        // 일반적인 경우: 'a'->'b', 'b'->'c' 등
        if ((curr - prev) == 1) return true;

        // wraparound 경우: 'z'->'a'
        if (prev == 'z' && curr == 'a') return true;

        return false;
    }
}
