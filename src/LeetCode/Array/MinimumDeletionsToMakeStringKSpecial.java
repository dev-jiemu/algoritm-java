package src.LeetCode.Array;

// 3085. Minimum Deletions to Make String K-Special
// https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/
public class MinimumDeletionsToMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int result = Integer.MAX_VALUE;

        // 소문자 총 26개
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            int base = freq[i];
            int deletions = 0;

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) {
                    continue;
                }

                if (freq[j] < base) {
                    deletions += freq[j];
                } else if (freq[j] > base + k) {
                    deletions += freq[j] - (base + k);
                }
            }

            result = Math.min(result, deletions);
        }

        return result;
    }
}
