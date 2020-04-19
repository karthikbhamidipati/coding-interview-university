package sorting;

import static datastructure.MaxHeap.getChildIndex;
import static datastructure.MaxHeap.swapValues;

public class HeapSort {

    private int[] data;
    private int size;

    public HeapSort(int[] data) {
        this.data = data;
        this.size = this.data.length;
        heapify();
    }

    private void heapify() {
        for(int i = this.size - 1; i >= 0; i--) {
            siftDown(i, this.size - 1);
        }
    }

    private void siftDown(int index, int length) {
        int lcIndex = getChildIndex(index);
        int rcIndex = lcIndex + 1;

        if (lcIndex >= length)
            return;

        if (data[lcIndex] > data[index] && data[lcIndex] > data[rcIndex]) {
            swapValues(data, index, lcIndex);
            siftDown(lcIndex, length);
        } else if (data[rcIndex] > data[index]) {
            swapValues(data, index, rcIndex);
            siftDown(rcIndex, length);
        }
    }
    
    public void sort() {
        int length = this.size - 1;
        for (int i = this.size - 1; i > 0; i--) {
            swapValues(data, 0, i);
            siftDown(0, --length);
        }
    }
}
