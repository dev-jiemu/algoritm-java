package src.LeetCode.TwoPointers;

// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean result = false;

        if (s.length() == 0) return true;

        int left = 0;
        int right = 0;

        while (right < t.length()) {
            if (t.charAt(right) == s.charAt(left)) {
                left++;

                if (left == s.length()) {
                    return true;
                }
            }

            right++;
        }

        return result;
    }
}
