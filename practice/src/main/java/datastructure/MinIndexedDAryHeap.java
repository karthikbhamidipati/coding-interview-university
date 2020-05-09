package datastructure;

import java.util.Arrays;
import java.util.Stack;

public class MinIndexedDAryHeap<K, V extends Comparable<V>> {

    private static final int DEFAULT_CAPACITY = 256;
    private final int degree;
    private final BiDirHashTable<K, Integer> hashTable;
    private final Stack<Integer> insertIndexStack;
    private final Object[] values;
    private final int[] posMap;
    private final int[] heapIndexMap;

    private int size;

    public MinIndexedDAryHeap(int degree) {
        this(degree, DEFAULT_CAPACITY);
    }

    public MinIndexedDAryHeap(int degree, int capacity) {
        this.degree = degree;
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.size = 0;
        this.hashTable = new BiDirHashTable<>();
        this.values = new Object[capacity];
        this.posMap = new int[capacity];
        this.heapIndexMap = new int[capacity];
        this.insertIndexStack = new Stack<>();
        this.insertIndexStack.push(0);
        Arrays.fill(posMap, -1);
        Arrays.fill(heapIndexMap, -1);
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean contains(K key) {
        return hashTable.keyExists(key);
    }

    public K peekMinKey() {
        return hashTable.getKey(heapIndexMap[0]);
    }

    @SuppressWarnings("unchecked")
    public V peekMinValue() {
        return (V) values[heapIndexMap[0]];
    }

    public V pollMinValue() {
        V minValue = peekMinValue();
        delete(peekMinKey());
        return minValue;
    }

    public void insert(K key, V value) {
        int index = insertIndexStack.pop();
        hashTable.add(key, index);
        values[index] = value;
        posMap[index] = size;
        heapIndexMap[size] = index;
        siftUp(size++);
        if (insertIndexStack.empty()) {
            insertIndexStack.push(size);
        }
    }

    @SuppressWarnings("unchecked")
    public V valueOf(K key) {
        Integer valueIndex = hashTable.getValue(key);
        if (valueIndex == null) {
            throw new IllegalArgumentException("key doesn't exist" + key);
        } else {
            return (V) values[valueIndex];
        }
    }

    public void delete(K key) {
        Integer keyIndex = hashTable.getValue(key);
        if (keyIndex == null) {
            throw new IllegalArgumentException("key doesn't exist " + key);
        }
        insertIndexStack.push(keyIndex);
        hashTable.remove(key, keyIndex);
        values[keyIndex] = null;
        int i = posMap[keyIndex];
        swap(i, --size);
        siftUp(i);
        siftDown(i);
        heapIndexMap[size] = -1;
        posMap[keyIndex] = -1;
    }

    public void update(K key, V value) {
        Integer keyIndex = hashTable.getValue(key);
        if (keyIndex == null) {
            throw new IllegalArgumentException("key doesn't exist" + key);
        }
        values[keyIndex] = value;
        siftUp(posMap[keyIndex]);
        siftDown(posMap[keyIndex]);
    }

    public void decrease(K key, V value) {
        Integer keyIndex = hashTable.getValue(key);
        if (keyIndex == null) {
            throw new IllegalArgumentException("key doesn't exist" + key);
        }
        values[keyIndex] = value;
        siftUp(posMap[keyIndex]);
    }

    public void increase(K key, V value) {
        Integer keyIndex = hashTable.getValue(key);
        if (keyIndex == null) {
            throw new IllegalArgumentException("key doesn't exist" + key);
        }
        values[keyIndex] = value;
        siftDown(posMap[keyIndex]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < heapIndexMap.length && heapIndexMap[i] != -1; i++) {
            int keyIndex = heapIndexMap[i];
            K key = hashTable.getKey(keyIndex);
            V value = (V) values[keyIndex];
            sb.append(String.format("(%s, %s), ", key.toString(), value.toString()));
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }

    private void swap(int i, int j) {
        posMap[heapIndexMap[j]] = i;
        posMap[heapIndexMap[i]] = j;
        heapIndexMap[i] = heapIndexMap[i] + heapIndexMap[j];
        heapIndexMap[j] = heapIndexMap[i] - heapIndexMap[j];
        heapIndexMap[i] = heapIndexMap[i] - heapIndexMap[j];
    }

    @SuppressWarnings("unchecked")
    private void siftUp(int heapIndex) {
        int parentIndex = getParent(heapIndex);
        while (parentIndex != heapIndex && parentIndex >= 0 && (((V) values[heapIndexMap[heapIndex]]).compareTo((V) values[heapIndexMap[parentIndex]]) < 0)) {
            swap(heapIndex, parentIndex);
            heapIndex = parentIndex;
            parentIndex = getParent(heapIndex);
        }
    }

    private void siftDown(int heapIndex) {
        for (int minChildIndex = getMinChild(heapIndex); minChildIndex != -1; ) {
            swap(heapIndex, minChildIndex);
            heapIndex = minChildIndex;
            minChildIndex = getMinChild(heapIndex);
        }
    }

    @SuppressWarnings("unchecked")
    private int getMinChild(int i) {
        int index = -1;
        int from = getChildren(i);
        int to = Math.min(size, from + degree);

        for (int j = from; j < to; j++) {
            if (((V) values[heapIndexMap[j]]).compareTo((V) values[heapIndexMap[i]]) < 0) {
                index = i = j;
            }
        }
        return index;
    }

    public int getParent(int index) {
        return (index - 1) / degree;
    }

    public int getChildren(int index) {
        return (index * degree) + 1;
    }

}
