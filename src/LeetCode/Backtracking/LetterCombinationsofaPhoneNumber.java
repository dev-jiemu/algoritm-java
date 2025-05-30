package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // 0 ~ 9
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, mapping, digits, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, String[] mapping, String digits, int index, StringBuilder current) {
        if("".equals(digits)) return; // 빈 객체 체크

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 48을 빼면 0 ~ 9 사이가 나옴 :)
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        for(int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(result, mapping, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
