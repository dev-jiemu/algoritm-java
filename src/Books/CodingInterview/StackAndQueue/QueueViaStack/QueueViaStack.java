package src.Books.CodingInterview.StackAndQueue.QueueViaStack;

import java.util.Stack;

public class QueueViaStack<E> {
    private final Stack<E> stackEnqueue;
    private final Stack<E> stackDequeue;

    public QueueViaStack() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(E e) {
        stackEnqueue.push(e);
    }

    public E dequeue() {
        reverseStackEnqueue();

        return stackDequeue.pop();
    }

    public E peek() {
        reverseStackEnqueue();

        return stackDequeue.peek();
    }

    public int size() {
        return stackEnqueue.size() + stackDequeue.size();
    }

    private void reverseStackEnqueue() { // enqueue -> dequeue
        if (stackDequeue.isEmpty()) {
            while(!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
    }

}
