package src.Books.CodingInterview.LinkedListAndMap.LRUCache;

import java.util.Map;

public class LRUCache {
    private final class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
    }

    private final Map<Integer, Node> hashmap;
    public LRUCache(Map<Integer, Node> hashmap) {
        this.hashmap = hashmap;
    }

    private Node head;
    private Node tail;

    private static final int LRU_SIZE = 5;

    public int getEntry(int key) {
        Node node = hashmap.get(key);

        if (node != null) { // 사용시기 업데이트
            removeNode(node);
            addNode(node);

            return node.value;
        }

        return -1;
    }

    public void putEntry(int key, int value) {
        Node node = hashmap.get(key);

        if (node != null) {
            node.value = value;

            removeNode(node);
            addNode(node);
        } else {
            Node newNode = new Node();
            newNode.prev = null;
            newNode.next = null;
            newNode.value = value;
            newNode.key = key;

            if (hashmap.size() >= LRU_SIZE) { // 최근에 가장 적게 사용한 항목 제거
                hashmap.remove(tail.key);
                removeNode(tail);

            }

            addNode(newNode);
            hashmap.put(key, newNode);
        }
    }

    private void addNode(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

}
