package sorting;

import static datastructure.MaxHeap.getChildIndex;
import static datastructure.MaxHeap.swapValues;

public class HeapSort {

    private static void heapify(int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1);
        }
    }

    private static void siftDown(int[] arr, int index, int length) {
        int lcIndex = getChildIndex(index);
        int rcIndex = lcIndex + 1;

        if (lcIndex > length)
            return;

        if (rcIndex > length)
            rcIndex = lcIndex;

        if (arr[lcIndex] > arr[index] && arr[lcIndex] > arr[rcIndex]) {
            swapValues(arr, index, lcIndex);
            siftDown(arr, lcIndex, length);
        } else if (arr[rcIndex] > arr[index]) {
            swapValues(arr, index, rcIndex);
            siftDown(arr, rcIndex, length);
        }
    }
    
    public static void sort(int[] arr) {
        heapify(arr);
        int length = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            swapValues(arr, 0, i);
            siftDown(arr, 0, --length);
        }
    }
}
