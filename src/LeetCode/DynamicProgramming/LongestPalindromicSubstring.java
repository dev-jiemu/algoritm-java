package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=dynamic-programming
public class LongestPalindromicSubstring {
    // 가장 긴 대칭문자열 찾기
    // 중심에서 확장해서 접근
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i + 1);

            int length = Math.max(length1, length2);

            // 더 긴 회문 찾았으면 업데이트
            if(length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    // DP 로 풀면 :: 디버그 꼭 돌려보기
    public String longestPalindromeDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";

        // 길이 1일때
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            result = s.substring(i, i + 1);
        }

        // 길이 2일때
        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result = s.substring(i, i + 2);
            }
        }

        // 길이가 3 이상일때
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;

                // 양끝이 같고 내부가 회문이면 전체도 회문
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }
}
