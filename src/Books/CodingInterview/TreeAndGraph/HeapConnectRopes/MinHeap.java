package src.Books.CodingInterview.TreeAndGraph.HeapConnectRopes;

import java.util.Arrays;

public class MinHeap {

    private int capacity;
    private int size;
    private int[] heap;

    public int minimumCost(int[] ropeLength) {
        if (ropeLength == null) return -1;

        for (int i = 0; i < ropeLength.length; i++) {
            add(ropeLength[i]);
        }

        int totalLength = 0;

        while (size() > 1) {
            int l1 = poll(); // 가장 짧은 밧줄을 가져옴
            int l2 = poll();

            totalLength += (l1 + l2);

            add(l1 + l2); // 계산해서 다시 넣음
        }

        return totalLength;
    }

    public void add(int element) {
        ensureCapacity();

        heap[size] = element;
        size++;

        heapifyUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int poll() {
        int element = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = -1;

        size--;

        heapifyDown();

        return element;
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int largestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                largestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] > heap[largestChildIndex]) {
                swap(index, largestChildIndex);
            } else {
                break;
            }

            index = largestChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    public int size() {
        return size;
    }
}
