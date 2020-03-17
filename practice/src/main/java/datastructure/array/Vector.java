package datastructure.array;

import java.util.Objects;

public class Vector<T> {

    private static final int DEFAULT_SIZE = 2;

    private Object[] elementData;
    private int capacity;
    private int size = 0;

    public Vector(int capacity) {
        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    public Vector() {
        this.capacity = DEFAULT_SIZE;
        elementData = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    public T at(int index) {
        Object val = elementData[index];
        if (Objects.isNull(val)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) val;
        }
    }

    public void push(T item) {
        this.insert(this.size, item);
    }

    public void insert(int index, T item) {
        if (index > this.capacity - 1 || this.size == this.capacity - 1) {
            this.resizeUp();
        }

        if (index > size) {
            this.elementData[index] = item;
            this.size = Math.max(this.size, index);
        } else {
            Object[] temp = new Object[this.capacity];
            this.copy(this.elementData, temp, 0, 0, index);
            temp[index] = item;
            this.copy(this.elementData, temp, index, index + 1, this.size - index);
            this.elementData = temp;
            this.size++;
        }
    }

    public void prepend(T item) {
        this.insert(0, item);
    }

    public T pop() {
        T val = this.at(--this.size);
        if (this.size <= this.capacity / 4) {
            resizeDown();
        }
        return val;
    }

    private void resizeDown() {
        Object[] temp = new Object[this.capacity /= 2];
        this.copy(elementData, temp, 0, 0, size);
        elementData = temp;
    }

    public void delete(int index) {
        if (index != size) {
            Object[] temp = new Object[this.capacity];
            this.copy(this.elementData, temp, 0, 0, index);
            this.copy(this.elementData, temp, index + 1, index, this.size - index);
            this.elementData = temp;
        }
        size--;
    }

    public void remove(T item) {
        Object[] temp = new Object[this.capacity];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!item.equals(elementData[i])) {
                temp[j++] = elementData[i];
            }
        }
        this.elementData = temp;
        this.size = j;
    }

    public int find(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    private void resizeUp() {
        Object[] temp = new Object[this.capacity *= 2];
        this.copy(this.elementData, temp, 0, 0, this.size);
        this.elementData = temp;
    }

    private void copy(Object[] arr1, Object[] arr2, int arr1StartIndex, int arr2StartIndex, int noOfItems) {
        while (noOfItems-- > 0) {
            arr2[arr2StartIndex++] = arr1[arr1StartIndex++];
        }
    }

}
