package src.LeetCode.DynamicProgramming;

// https://leetcode.com/problems/decode-ways/description/?envType=problem-list-v2&envId=dynamic-programming
public class DecodeWays {
    public int numDecodings(String s) {
        // dp[i] = 문자열의 처음부터 i번째 위치까지 디코딩할 수 있는 경우의 수
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            // 한자릿수
            int ondDigit = Integer.parseInt(s.substring(i-1, i));
            if (ondDigit >= 1 && ondDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
