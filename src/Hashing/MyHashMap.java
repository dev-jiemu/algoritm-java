package src.Hashing;

import src.MapInterface.MyLinearMap;

import java.util.List;
import java.util.Map;

public class MyHashMap<K, V> extends MyBetterMap<K, V> implements Map<K, V> {
    public static final double FACTOR = 1.0;

    @Override
    public V put (K key, V value) {
        V oldValue = super.put(key, value);

        // 하위 맵당 엔트리의 개수가 임계치를 넘는지 아닌지 확인
        if (size() > maps.size() * FACTOR) {
            rehash();
        }

        return oldValue;
    }

    public void clear() {
        for (int i = 0; i<maps.size(); i++) {
            maps.get(i).clear();
        }
    }

    protected void rehash() {
        // save the existing entries
        List<MyLinearMap<K, V>> oldMaps = maps;

        // make more maps
        int newK = maps.size() * 2;
        makeMaps(newK);

        // put the entries into the new map
        for (MyLinearMap<K, V> map: oldMaps) {
            for (Map.Entry<K, V> entry: map.getEntries()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
