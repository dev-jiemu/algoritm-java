package src.LeetCode.Greedy;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/?envType=problem-list-v2&envId=greedy
public class RemoveDuplicateLetters {
    // Greedy + Stack
    // 나중에 또 나올것 같으면 걍 미리 삭제하자는 의도 ㅇㅇ
    /*
        처리 과정 -
        b → stack: [b]
        c → stack: [b, c]
        a → c > a이고 c가 나중에 또 나옴 → c 제거
          → b > a이고 b가 나중에 또 나옴 → b 제거
          → stack: [a]
        b → stack: [a, b]
        c → stack: [a, b, c]

        result: "abc"
     */
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (inStack[c - 'a']) continue;

            // 현재 문자가 더 작고, 스택 top 이 나중에 다시 나온다면 제거
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
