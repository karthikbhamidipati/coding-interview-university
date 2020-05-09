package util;

public class Tuple2<K, V> {
    K key;
    V value;

    public Tuple2(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", key, value);
    }
}
