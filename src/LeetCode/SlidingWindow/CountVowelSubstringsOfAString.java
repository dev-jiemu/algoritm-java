package src.LeetCode.SlidingWindow;

import java.util.Set;

// https://leetcode.com/problems/count-vowel-substrings-of-a-string/
public class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        // 정확히 5개 모음 = 최소 5개이상 - 최소 6개이상
        // countExact(5) = countAtLeast(5) - countAtLeast(6)
        return atLeast(word, 5) - atLeast(word, 6);
    }

    private int atLeast(String word, int k) {
        int[] freq = new int[26];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int count = 0;

        int distinct = 0;
        int left = 0;

        for(int right = 0; right < word.length(); right++) {
            char c = word.charAt(right);

            if (!vowels.contains(c)) {
                freq = new int[26];
                distinct = 0;
                left = right + 1;
                continue;
            }

            if (freq[c - 'a']++ == 0) {
                distinct++;
            }

            while (distinct >= k) {
                char l = word.charAt(left);

                if (--freq[l - 'a'] == 0) {
                    distinct--;
                }

                left++;
            }

            count += left;
        }

        return count;
    }
}
