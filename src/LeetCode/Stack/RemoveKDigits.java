package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/description/?envType=problem-list-v2&envId=stack
public class RemoveKDigits {
    // 앞자리 숫자가 작을수록 전체 숫자가 작음
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        int remove = k;
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(remove > 0 && !stack.isEmpty() &&  stack.peek() > c) { // 스택의 마지막 숫자가 현재 숫자보다 크면 제거
                stack.pop();
                remove--;
            }
            stack.push(c);
        }

        // 횟수 남으면 남은거만큼 뒤에서 제거
        for (int j = 0; j < remove; j++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }

        // 선행 0 제거
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
