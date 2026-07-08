package src.LeetCode.String;

// 2380. Time Needed to Rearrange a Binary String
// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
public class TimeNeededToRearrangeABinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int result = 0;
        int zero = 0;

        for(char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                if (zero > 0) {
                    // 1이 이동하는데 걸리는 시간은 최소 zero초 인데, 중복이 있을수 있으니(이전 값도 이동중일수 있어서) max 값으로 판단
                    result = Math.max(result + 1, zero);
                }
            }
        }

        return result;
    }

    // 그냥 다이렉트로 움직여서 계산하는 방법도 있긴 함
    /*
    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int seconds = 0;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == '0' && arr[i + 1] == '1') {
                    arr[i] = '1';
                    arr[i + 1] = '0';
                    changed = true;
                    i++;
                }
            }
            if (changed) seconds++;
        }
        return seconds;
    }
     */
}
