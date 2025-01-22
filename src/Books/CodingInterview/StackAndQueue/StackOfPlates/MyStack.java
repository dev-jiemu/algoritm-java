package src.Books.CodingInterview.StackAndQueue.StackOfPlates;

import java.util.LinkedList;
import java.util.Stack;

public class MyStack {
    private static final int STACK_SIZE = 3;
    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();

    public void push(int value) {
        if (stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {
            Stack<Integer> stack = new Stack<>();
            stack.push(value);

            stacks.add(stack);
        } else {
            stacks.getLast().push(value);
        }
    }

    public Integer Pop() {
        Stack<Integer> lastStack = stacks.getLast();
        int value = lastStack.pop();

        removeStackIfEmpty();

        return value;
    }

    private void removeStackIfEmpty() {
        if (stacks.getLast().isEmpty()) {
            stacks.removeLast();
        }
    }

    public Integer popAt(int stackIdx) {
        int value = stacks.get(stackIdx).pop();
        shift(stackIdx); // 팝 한 이후에 정리
        removeStackIfEmpty();

        return value;
    }

    private void shift(int index) {
        for (int i = index; i < stacks.size() - 1; ++i) {
            Stack<Integer> currentStack = stacks.get(i);
            Stack<Integer> nextStack = stacks.get(i + 1);

            currentStack.push(nextStack.remove(0));
        }
    }
}
