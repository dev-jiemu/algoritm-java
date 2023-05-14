package src.MapInterface;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V> {

    private int size = 0;
    private Node root = null;

   protected class Node {
        public K key;
        public V value;
        public Node left = null;
        public Node right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
   }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private Node findNode(Object target) {
       if (target == null) {
           throw new IllegalArgumentException();
       }

       @SuppressWarnings("unchecked")
       Comparable<? super K> k = (Comparable<? super K>) target;

       Node node = root;
       while (node != null) {
           int cmp = k.compareTo(node.key);
           if (cmp < 0) { // 작으면 왼쪽
               node = node.left;
           } else if (cmp > 0 ) { // 크면 오른쪽
               node = node.right;
           } else {
               return node; // 0이면 본인
           }
       }

       return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    // 탐색: 재귀호출
    @Override
    public boolean containsValue(Object value) {
        return containsValueHelper(root, value);
    }

    private boolean containsValueHelper(Node node, Object target) {
        if (node == null) {
            return false;
        }
        if (equals(target, node.value)) {
             return true;
        }
        if (containsValueHelper(node.right, target)) {
            return true;
        }

       return false;
    }

    private boolean equals(Object target, Object obj) {
        if (target == null) {
            return obj == null;
        }
        return target.equals(obj);
    }


    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (root == null) {
            root = new Node(key, value);
            size++;
            return null;
        }

        return putHelper(root, key, value);
    }

    // key가 이미 트리에 있으면 기존 값을 새로운 값으로 대체하고 기존 값을 반환함
    // key가 트리에 없으면 새로운 노드를 만들고 이 노드를 추가할 알맞은 위치를 찾은 다음 null을 반환함
    private V putHelper(Node node, K key, V value) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(node.key);

        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.left, key, value);
            }
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.right, key, value);
            }
        }

        V oldValue = node.value;
        node.value = value;

        return oldValue;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    // key를 순서대로 포험하는 set 객체를 반환해야 함
    @Override
    public Set<K> keySet() {
       Set<K> set = new LinkedHashSet<>();
       addInOrder(root, set);
       return set;
    }

    // 재귀호출 : 중위 순회를 실행함
    // BST 속성은 왼쪽 하위 트리의 모든 노드가 node.key 보다 작고, 오른쪽 모든 노드가 큼을 보장함.
    private void addInOrder(Node node, Set<K> set) {
       if (node == null) {
           return;
       }

       addInOrder(node.left, set);
       set.add(node.key);
       addInOrder(node.right, set);
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
