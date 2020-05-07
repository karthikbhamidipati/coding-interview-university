package sorting;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class SortTest {
    private static int[] data;
    private static int[] topDownMergeSortData;
    private static int[] bottomUpMergeSortData;
    private static int[] quickSortData;
    private static int[] heapSortData;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        data = new Random().ints(50000, 0, 100000).toArray();
        System.out.println("Input data : " + Arrays.toString(data));
        topDownMergeSortData = Arrays.copyOf(data, data.length);
        bottomUpMergeSortData = Arrays.copyOf(data, data.length);
        quickSortData = Arrays.copyOf(data, data.length);
        heapSortData = Arrays.copyOf(data, data.length);

        long startTime = System.nanoTime();
        Arrays.sort(data);
        long endTime = System.nanoTime();
        System.out.println("Execution time of Arrays sort in nanoseconds : " + (endTime - startTime));
        System.out.println("Sorted Data using Arrays sort : " + Arrays.toString(data));

    }

    @Test
    public void testBottomUpMergeSort() {
        long startTime = System.nanoTime();
        BottomUpMergeSort.sort(bottomUpMergeSortData);
        long endTime = System.nanoTime();
        System.out.println("Execution time of BottomUpMergeSort sort in nanoseconds : " + (endTime - startTime));

        System.out.println("Sorted Data using BottomUpMergeSort : " + Arrays.toString(bottomUpMergeSortData));
        collector.checkThat("Data not sorted", Arrays.equals(data, bottomUpMergeSortData), equalTo(true));
    }

    @Test
    public void testTopDownMergeSort() {
        long startTime = System.nanoTime();
        TopDownMergeSort.sort(topDownMergeSortData);
        long endTime = System.nanoTime();
        System.out.println("Execution time of TopDownMergeSort sort in nanoseconds : " + (endTime - startTime));

        System.out.println("Sorted Data using TopDownMergeSort : " + Arrays.toString(topDownMergeSortData));
        collector.checkThat("Data not sorted", Arrays.equals(data, topDownMergeSortData), equalTo(true));
    }

    @Test
    public void testQuickSort() {
        long startTime = System.nanoTime();
        QuickSort.sort(quickSortData);
        long endTime = System.nanoTime();
        System.out.println("Execution time of QuickSort in nanoseconds : " + (endTime - startTime));

        System.out.println("Sorted Data using QuickSort : " + Arrays.toString(quickSortData));
        collector.checkThat("Data not sorted", Arrays.equals(data, quickSortData), equalTo(true));
    }

    @Test
    public void testHeapSort() {
        long startTime = System.nanoTime();
        HeapSort.sort(heapSortData);
        long endTime = System.nanoTime();
        System.out.println("Execution time of HeapSort in nanoseconds : " + (endTime - startTime));

        System.out.println("Sorted Data using HeapSort : " + Arrays.toString(heapSortData));
        collector.checkThat("Data not sorted", Arrays.equals(data, heapSortData), equalTo(true));
    }

}
