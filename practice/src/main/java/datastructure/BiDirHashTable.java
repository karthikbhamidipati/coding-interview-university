package datastructure;

import java.util.HashMap;
import java.util.Map;

public class BiDirHashTable<K, V> {
    private final Map<K, V> keyIndexed;
    private final Map<V, K> valueIndexed;

    public BiDirHashTable() {
        keyIndexed = new HashMap<>();
        valueIndexed = new HashMap<>();
    }

    public void add(K key, V value) {
        if (keyExists(key)) {
            remove(key, getValue(key));
        } else if (valueExists(value)) {
            throw new IllegalArgumentException("Updates with existing values not allowed");
        }
        keyIndexed.put(key, value);
        valueIndexed.put(value, key);
    }

    public boolean keyExists(K key) {
        return keyIndexed.containsKey(key);
    }

    public boolean valueExists(V value) {
        return valueIndexed.containsKey(value);
    }

    public K getKey(V value) {
        return valueIndexed.get(value);
    }

    public V getValue(K key) {
        return keyIndexed.get(key);
    }

    public void remove(K key, V value) {
        keyIndexed.remove(key);
        valueIndexed.remove(value);
    }
}
