package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// 784. Letter Case Permutation
// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, String s, int index, StringBuilder path) {
        if (index == s.length()) {
            result.add(path.toString());
            return;
        }

        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            // 소문자 먼저
            path.append(Character.toLowerCase(c));
            backtrack(result, s, index + 1, path);
            path.deleteCharAt(path.length() - 1);

            // 대문자 나중에
            path.append(Character.toUpperCase(c));
            backtrack(result, s, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        } else { // 숫자
            path.append(c);
            backtrack(result, s, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
