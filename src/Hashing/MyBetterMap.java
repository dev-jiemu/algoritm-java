package src.Hashing;

import src.MapInterface.MyLinearMap;

import java.util.*;

// 내장된 맵에 따라 키를 나누므로 각 맵의 엔트리 개수는 더 줄어듬.
public class MyBetterMap<K, V> implements Map<K, V> {

    protected List<MyLinearMap<K, V>> maps;

    public MyBetterMap() {
        makeMaps(2);
    }

    protected void makeMaps(int k) {
        maps = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            maps.add(new MyLinearMap<K, V>());
        }
    }

    // 키를 살펴보고 어느 맵에 투입할지를 결정해야 함 : hash function
    // 주어진 키에 대한 적합한 하위 맵을 고르는 헬퍼 메서드
    protected MyLinearMap<K, V> chooseMap(Object key) {
        int index = 0;

        if (key != null) {
            // null이 아니면 hashCode 메서드를 호출해서 정수를 얻고, 절대값으로 변환
            // 이후 나머지 연산자를 사용해서 결과가 0 ~ map.size()-1 사이에 있음을 보장함.
            index = Math.abs(key.hashCode()) % maps.size();
        }

        return maps.get(index);
    }

    @Override
    public boolean containsKey(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.containsKey(key);
    }

    @Override
    public V get(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.put(key, value);
    }

    @Override
    public int size() {
        int total = 0;

        for (MyLinearMap<K, V> map: maps) {
            total += map.size();
        }

        return total;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
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
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
