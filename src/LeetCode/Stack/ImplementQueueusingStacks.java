package src.LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

// 232. Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueusingStacks {
    // 하나는 넣는 전용 Deque, 하나는 빼는 전용 Deque
    private final Deque<Integer> in = new ArrayDeque<>();
    private final Deque<Integer> out = new ArrayDeque<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        move();
        return out.pop();
    }

    public int peek() {
        move();
        return out.peek();
    }

    // 둘다 체크해야함
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
