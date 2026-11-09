package src.LeetCode.TwoPointers;

// 1839. Longest Substring Of All Vowels in Order
// https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/description/
public class LongestSubstringOfAllVowelsinOrder {
    public int longestBeautifulSubstring(String word) {
        int result = 0;
        int left = 0;
        int distinct = 1;

        for(int right = 1; right < word.length(); right++) {
            char prev = word.charAt(right - 1);
            char cur = word.charAt(right);

            // 순서가 깨짐 = 새로시작
            if(cur < prev) {
                left = right;
                distinct = 1;
            } else if (cur > prev) {
                distinct++;
            }

            if (distinct == 5) {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
