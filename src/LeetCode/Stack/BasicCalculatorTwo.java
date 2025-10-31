package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/description/?envType=problem-list-v2&envId=stack
public class BasicCalculatorTwo {
    public int calculate(String s) {
        int result = 0;

        // *랑 / 만나면 하나 꺼내서 연산하고 push
        // 나머지는 바로 만들어서 push

        int num = 0;
        char operation = '+';

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    stack.push(stack.pop() * num);
                } else if (operation == '/') {
                    stack.push(stack.pop() / num);
                }

                if (c != ' ' && !Character.isDigit(c)) {
                    operation = c;
                }

                // reset
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
