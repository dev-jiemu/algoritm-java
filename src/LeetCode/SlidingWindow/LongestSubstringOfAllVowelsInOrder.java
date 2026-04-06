package src.LeetCode.SlidingWindow;

// 1839. Longest Substring Of All Vowels in Order
// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
public class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int left = 0;
        int maxLength = 0;
        int uniqueCount = 1; // 윈도우 내에 서로 다른 모음수

        for (int right = 1; right < word.length(); right++) {
            char current = word.charAt(right);
            char prev = word.charAt(right-1);

            if (current == prev) {
                // 윈도우 유지 ㅇㅇ
            } else if (current > prev) {
                uniqueCount++;
            } else {
                left = right;
                uniqueCount = 1;
            }

            if (uniqueCount == 5) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
