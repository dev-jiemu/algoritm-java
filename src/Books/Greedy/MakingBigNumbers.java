package src.Books.Greedy;

import java.util.Stack;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class MakingBigNumbers {
    // k개를 무족건 지운다는건 = 맨 앞자리 숫자가 큰게 큰 수일 확률이 높음
    public String solution(String number, int k) {

        // stack
        // 앞숫자가 뒤숫자보다 작으면 remove
        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && c > stack.peek()) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while(k-- > 0) {
            stack.pop();
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
