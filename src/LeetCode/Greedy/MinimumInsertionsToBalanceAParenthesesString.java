package src.LeetCode.Greedy;

import java.util.ArrayDeque;
import java.util.Deque;

// 1541. Minimum Insertions to Balance a Parentheses String
// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
public class MinimumInsertionsToBalanceAParenthesesString {
    // 쌍 맞추기니까 Stack 생각했는데 1:2 비율이라 스텍으로는 좀 까다로운듯
    // 카운터 세는 형식의 그리디로 접근하면, 공간 복잡도 O(1)
    public int minInsertions(String s) {
        int result = 0;

        int open = 0;  // ( 개수
        int n = s.length();
        int index = 0;

        while (index < n) {
            char c = s.charAt(index);
            if (c == '(') {
                open++;
                index++;
            } else { // ) 일때
                if (index + 1 < n && s.charAt(index + 1) == ')') { // 그 다음 인덱스도 ) 면
                    index += 2;
                } else {
                    result++;
                    index++;
                }

                if (open > 0) {
                    open--;
                } else { // 짝지을 ( 가 없으니까 넣음
                    result++;
                }
            }
        }

        result += open * 2; // 남은거 있으면 처리

        return result;
    }

    // 처음 생각했던 Stack 으로 풀면 : O(n)
    public int minInsertionsWithStack(String s) {
        int result = 0;

        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        int n = s.length();

        while(index < n) {
            char c = s.charAt(index);
            if (c == '(') {
                stack.push(c);
                index++;
            } else {
                if (stack.isEmpty()) {
                    result++; // 짝지을거 없음
                } else {
                    stack.pop();
                }

                if (index + 1 < n && s.charAt(index + 1) == ')') { // 다음글자 확인
                    index += 2; // 건너뛰기
                } else {
                    result++;
                    index++;
                }
            }
        }

        // 남은거 처리
        result += stack.size() * 2;
        return result;
    }
}
