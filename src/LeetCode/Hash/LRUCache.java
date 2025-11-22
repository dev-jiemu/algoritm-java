package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/?envType=problem-list-v2&envId=hash-table
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    // Dummy node
    private Node head; // 가장 최근에 사용
    private Node tail; // 가장 오래된 사용

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail; // 연결
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);
        // 노드 이동처리
        removeNode(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToHead(newNode);

        // 용량 초과 처리
        if (cache.size() > capacity) {
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

// LinkedHashMap 으로도 구현하면 편하긴 한데 좀더 구현해보고 싶어서 ㅇㅂㅇ
/*
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
 */