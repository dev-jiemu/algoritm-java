package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (!stack.isEmpty()) {
                    char current = stack.peek();

                    if ((current == '(' && s.charAt(i) == ')') || (current == '{' && s.charAt(i) == '}') || (current == '[' && s.charAt(i) == ']')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false; // 짝이 없음
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
