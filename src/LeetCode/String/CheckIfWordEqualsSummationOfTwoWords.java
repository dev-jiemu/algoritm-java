package src.LeetCode.String;

// 1880. Check if Word Equals Summation of Two Words
// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/
public class CheckIfWordEqualsSummationOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNum(firstWord) + toNum(secondWord) == toNum(targetWord);
    }

    // 10진수 숫자로 변환
    private int toNum(String word) {
        int result = 0;
        for (char c : word.toCharArray()) {
            result = result * 10 + (c - 'a');
        }
        return result;
    }
}
