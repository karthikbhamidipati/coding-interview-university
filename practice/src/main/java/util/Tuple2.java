package util;

import java.util.Objects;

public class Tuple2<K, V> {
    K key;
    V value;

    public Tuple2(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(key, tuple2.key) &&
                Objects.equals(value, tuple2.value);
    }

}
