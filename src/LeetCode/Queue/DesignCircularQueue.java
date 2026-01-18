package src.LeetCode.Queue;

// https://leetcode.com/problems/design-circular-queue/description/?envType=problem-list-v2&envId=queue
public class DesignCircularQueue {
    // Arraylist 말고 그냥 배열로 구현해야 함
    // 원형 큐의 고정크기, 공간 재사용을 구현하려면 arraylist 는 적합하지 않음

    private int[] queue;
    private int front;
    private int rear;
    private int size; // 현재 원소 개수
    private int capacity; // max size

    public DesignCircularQueue(int k) {
        this.size = 0;
        this.capacity = k;
        this.front = 0;
        this.rear = -1;
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        this.rear = (this.rear + 1) % this.capacity;
        this.queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        // 삭제하는거니까 front를 옮김
        this.front = (front + 1) % this.capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return this.queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return this.queue[rear];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.capacity == this.size;
    }

}
