package src.LeetCode.BFSandDFS;

import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {
    // 인터페이스지만 코드 빨간줄 방지용으로 대강 넣음
    class NestedInteger {
        public NestedInteger(int i) {}

        public NestedInteger() {}

        public void add(NestedInteger ni) {}
    }

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        boolean isNegative = false; // 음수
        boolean hasNumber = false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                // 숫자가 있으면 현재 리스트에 추가
                if (hasNumber) {
                    int finalNum = isNegative ? -num : num;
                    stack.peek().add(new NestedInteger(finalNum));
                    num = 0;
                    isNegative = false;
                    hasNumber = false;  // ← 리셋!
                }

                // ]일 때만 중첩 처리
                if (c == ']' && stack.size() > 1) {
                    NestedInteger completed = stack.pop();
                    stack.peek().add(completed);
                }
            } else if (c == '-') { // 음수
                isNegative = true;
            } else {
                num = num * 10 + (c - '0');
                hasNumber = true;
            }
        }

        return stack.pop();
    }
}
