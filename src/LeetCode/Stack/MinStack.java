package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop(); // 최소값 제거
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
