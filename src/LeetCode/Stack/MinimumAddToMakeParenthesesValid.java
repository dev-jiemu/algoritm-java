package src.LeetCode.Stack;

// 921. Minimum Add to Make Parentheses Valid
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        // stack 객체를 직접 만들면 직설적이긴 한데, 굳이 안 만들고 카운트로 세도 될듯
        int open = 0;
        int add = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }

        return open + add;
    }
}
