package src.Books.ProgrammersTest.Stack;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class RotateParentheses {
    public int solution(String s) {
        char[] str = s.toCharArray();
        int count = 0;

        for (int offset = 0; offset < str.length; offset++) {
            if(isCorrect(str, offset)) {
                count++;
            }
        }

        return count;
    }

    // 짝 맞는지 체크해야함
    private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            char c = str[(offset + i) % str.length];  // substring 으로 구현할수 있긴 한데 이건 매번 쓸때마다 문자열을 새로 만듬
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[' :
                    stack.push(']');
                    break;
                case ')' :
                case '}' :
                case ']' :
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
