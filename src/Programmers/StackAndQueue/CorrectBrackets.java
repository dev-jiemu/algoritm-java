package src.Programmers.StackAndQueue;

import java.util.Stack;

//스택 자료구조 사용: 문자열을 순회하면서 여는 괄호일 경우 푸쉬, 닫는 괄호일 경우 팝 하는 식으로 처리
public class CorrectBrackets {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
            } else if (bracket == ')') {
                if (stack.isEmpty()) {
                    return false; // 여는 괄호 없이 닫는 괄호가 나온 경우
                }
                stack.pop(); // 짝을 맞추어 스택에서 제거
            }
        }

        return stack.isEmpty(); // 스택이 비어 있으면 올바른 문자열
    }

    public static void main(String[] args) {
        String data = "(())()";

        boolean result = solution(data);

        System.out.println("result : " + result);
    }
}
