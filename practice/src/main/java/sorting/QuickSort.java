package sorting;

import java.util.Random;

import static datastructure.MaxHeap.swapValues;

public class QuickSort {
    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int start, int end) {
        if (start < end) {
            if (end - start <= 10) {
                insertionSort(data, start, end);
            } else {
                int pivot = partition(data, start, end);
                sort(data, start, pivot - 1);
                sort(data, pivot + 1, end);
            }
        }
    }

    private static int partition(int[] data, int start, int end) {
//        medianOfThree(data, start, end); //not efficient
        median(data, start, end);
        int pivotElement = data[start];
        int i = start + 1;
        int j = end;

        while (j > i) {
            while (i <= j && data[i] <= pivotElement) {
                i++;
            }

            while (j >= i && data[j] >= pivotElement) {
                j--;
            }

            if (j > i) {
                swapValues(data, i, j);
            }
        }
        swapValues(data, start, j);
        return j;
    }

    private static void median(int[] data, int start, int end) {
        int center = (start + end) / 2;

        if (data[start] < data[center])
            swapValues(data, start, center);

        if (data[start] < data[end])
            swapValues(data, start, end);

        if (data[center] < data[end])
            swapValues(data, center, end);

        swapValues(data, center, start);
    }

    private static void medianOfThree(int[] data, int start, int end) {
        int[] rIndexes = new Random().ints(3, start, end).toArray();

        if (data[rIndexes[0]] < data[rIndexes[1]]) {
            if (data[rIndexes[1]] < data[rIndexes[2]]) {
                swapValues(data, start, rIndexes[1]);
            } else {
                swapValues(data, start, rIndexes[2]);
            }
        } else {
            if (data[rIndexes[0]] < data[rIndexes[2]]) {
                swapValues(data, start, rIndexes[0]);
            } else {
                swapValues(data, start, rIndexes[2]);
            }
        }
    }

    private static void insertionSort(int[] data, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j > start; j--) {
                if (data[j] < data[j - 1]) {
                    swapValues(data, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
