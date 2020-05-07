package datastructure;

public class MaxHeap {
    private static final int DEFAULT_CAPACITY = 16;

    private int[] data;
    private int size;
    private int capacity;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity) {
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.size = 0;
        data = new int[this.capacity];
    }

    public void insert(int value) {
        reSizeArray();
        this.data[this.size] = value;
        siftUp(this.size);
        this.size++;
    }

    private void siftUp(int index) {
        if (index == 0)
            return;

        int pIndex = getParentIndex(index);
        if (this.data[pIndex] < this.data[index]) {
            swapValues(this.data, index, pIndex);
        }

        siftUp(pIndex);
    }

    public int getMax() {
        return this.data[0];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int extractMax() {
        int max = this.data[0];
        swapValues(this.data, 0, --this.size);
        this.data[this.size] = 0;
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        int lcIndex = getChildIndex(index);
        int rcIndex = lcIndex + 1;

        if (lcIndex >= this.size)
            return;

        if (data[lcIndex] > data[index] && data[lcIndex] > data[rcIndex]) {
            swapValues(data, index, lcIndex);
            siftDown(lcIndex);
        } else if (data[rcIndex] > data[index]) {
            swapValues(data, index, rcIndex);
            siftDown(rcIndex);
        }
    }

    public void remove(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds" + index);
        }
        swapValues(this.data, index, --this.size);
        this.data[this.size] = 0;
        siftDown(index);
        siftUp(index);
    }

    public static int getChildIndex(int index) {
        return (2 * index) + 1;
    }

    private void reSizeArray() {
        if (this.size >= this.capacity - 1) {
            this.capacity *= this.capacity < 50000 ? 4 : 2;
            int[] temp = new int[this.capacity];
            System.arraycopy(this.data, 0, temp, 0, this.size + 1);
            data = temp;
        }
    }

    public static void swapValues(int[] data, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        data[index1] = data[index1] + data[index2];
        data[index2] = data[index1] - data[index2];
        data[index1] = data[index1] - data[index2];
    }

    public static int getParentIndex(int index) {
        return ((index + 1) / 2) - 1;
    }

}
