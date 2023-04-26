package src.MapInterface;

import java.util.*;

public class MyLinearMap<K, V> implements Map<K, V> {

    private List<Entry> entries = new ArrayList<>();

    public class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        }

        return (V) entry.getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry entry = findEntry(key);
        if (entry == null) {
            entries.add(new Entry(key, value));
            return null;
        } else {
            V oldValue = (V) entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
    }

    @Override
    public V remove(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        } else {
            V value = (V) entry.getValue();
            entries.remove(entry);
            return value;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private Entry findEntry(Object target) {
        for(Entry entry: entries) {
            if (equals(target, entry.getKey())) {
                return entry;
            }
        }

        return null;
    }

    // 실행시간: target과 키의 크기에 의존함
    private boolean equals(Object target, Object obj) {
        if (target == null) {
            return obj == null;
        }

        return target.equals(obj);
    }
}


