package src.Books.CodingInterview.LinkedListAndMap.LinkedListRemoveDuplicates;

import java.util.HashSet;
import java.util.Set;

// 정렬 안된 연결 리스트의 중복요소 제거
public final class RemoveDuplicates {
    private final class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // 1. Set 활용
    public void removeDuplicateSet() {
        Set<Integer> dataSet = new HashSet<>();

        Node currentNode = head;
        Node prevNode = null;

        while(currentNode != null) {
            if (dataSet.contains(currentNode.data)) {
                prevNode.next = currentNode.next;

                if (currentNode == tail) {
                    tail = prevNode;
                }

                size--;
            } else {
                dataSet.add(currentNode.data);
                prevNode = currentNode;
            }

            currentNode = currentNode.next;
        }
    }

    // 공간 복잡도 O(1) 로 처리
    // 순회 노드 포인터
    public void removeDuplicatePointer() {
        Node currentNode = head;

        while (currentNode != null) {
            Node runnerNode = currentNode;

            while(runnerNode.next != null) {
                if (runnerNode.next.data == currentNode.data) {
                    if (runnerNode.next == tail) {
                        tail = runnerNode;
                    }

                    runnerNode.next = runnerNode.next.next;
                    size--;
                } else {
                    runnerNode = runnerNode.next;
                }
            }

            currentNode = currentNode.next;
        }
    }
}
