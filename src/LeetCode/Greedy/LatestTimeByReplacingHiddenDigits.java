package src.LeetCode.Greedy;

// 1736. Latest Time by Replacing Hidden Digits
// https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/description/
public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();

        // 시
        // 십의자리
        if (t[0] == '?') {
            t[0] = (t[1] == '?' || t[1] <= '3') ? '2' : '1';
        }

        // 일의자리
        if(t[1] == '?') {
            t[1] = (t[0] == '2') ? '3' : '9';
        }

        // 분 (근데 얘네는 그냥 고정)
        if (t[3] == '?') {
            t[3] = '5';
        }

        if (t[4] == '?') {
            t[4] = '9';
        }

        return new String(t);
    }
}
