package src.ListClass;

import java.util.List;

public abstract class MyLinkedList<T> implements List<T> {

    private class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node head;

    protected MyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head; // 반복문 실행 전 node를 선언해야만 함
            for ( ; node.next != null; node = node.next) {}
                node.next = new Node(element);
        }
        size++;
        return true;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int indexOf(Object target) {
        Node node = head;
        for (int i = 0; i<size; i++) {
             if (equals(target, head.data)) {
                 return i;
             }
             node = node.next; // 못 찾으면 다음 노드를 탐색
        }
        return -1;
    }

    private boolean equals(Object target, T data) {
        if (target == null) {
            return data == null;
        } else {
            return target.equals(data);
        }
    }

    public void add(int index, T element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node node = getNode(index-1);
            node.next = new Node(element, node.next);
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for(int i = 0; i<index; i++) {
            node = node.next;
        }

        return node;
    }

    public T remove(int index) {
        T element = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node node = getNode(index-1);
            node.next = node.next.next;
        }

        size--;
        return element;
    }

}