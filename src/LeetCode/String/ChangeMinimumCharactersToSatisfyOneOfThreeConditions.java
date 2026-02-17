package src.LeetCode.String;

// https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public int minCharacters(String a, String b) {
        // Math.min
        int result = Integer.MAX_VALUE;

        // 빈도 배열
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for (char c : a.toCharArray()) freqA[c - 'a']++;
        for (char c : b.toCharArray()) freqB[c - 'a']++;

        // 누적합 배열
        int[] prefixA = new int[26];
        int[] prefixB = new int[26];

        prefixA[0] = freqA[0];
        prefixB[0] = freqB[0];

        for (int i = 1; i < 26; i++) {
            prefixA[i] = prefixA[i - 1] + freqA[i];
            prefixB[i] = prefixB[i - 1] + freqB[i];
        }

        // 1번
        for (int i = 1; i < 26; i++) {
            int cost = (a.length() - prefixA[i - 1]) + prefixB[i - 1];
            result = Math.min(result, cost);
        }

        // 2번
        for (int i = 1; i < 26; i++) {
            int cost = (b.length() - prefixB[i - 1]) + prefixA[i - 1];
            result = Math.min(result, cost);
        }

        // 3번 : 문자 맞춤
        for (int i = 0; i < 26; i++) {
            int cost = (a.length() - freqA[i]) + (b.length() - freqB[i]);
            result = Math.min(result, cost);
        }

        return result;
    }
}
