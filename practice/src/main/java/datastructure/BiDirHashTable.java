package datastructure;

public class BiDirHashTable<K, V> {
    private final HashTable<K, V> keyIndexed;
    private final HashTable<V, K> valueIndexed;

    public BiDirHashTable() {
        keyIndexed = new HashTable<>();
        valueIndexed = new HashTable<>();
    }

    public void add(K key, V value) {
        if (keyExists(key)) {
            remove(key, getValue(key));
        } else if (valueExists(value)) {
            throw new IllegalArgumentException("Updates with existing values not allowed");
        }
        keyIndexed.add(key, value);
        valueIndexed.add(value, key);
    }

    public boolean keyExists(K key) {
        return keyIndexed.exists(key);
    }

    public boolean valueExists(V value) {
        return valueIndexed.exists(value);
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
