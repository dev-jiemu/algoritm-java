package src.LeetCode.Queue;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/design-circular-deque/?envType=problem-list-v2&envId=queue
public class DesignCircularDeque {
    private Deque<Integer> deque;
    private int maxSize = 0;

    public DesignCircularDeque(int k) {
        this.deque = new LinkedList<>();
        this.maxSize = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        deque.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque.addLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        deque.removeFirst();
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        deque.removeLast();
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque.getFirst();
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque.getLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == this.maxSize;
    }
}
