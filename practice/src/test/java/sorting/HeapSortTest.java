package sorting;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

public class HeapSortTest {
    private static HeapSort heapSort;
    private static int[] data;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        data = new int[]{50, 30, 45, 80, 15, 2, 49, 63, 34, 89, 73, 55, 67, 29, 44, 24};
        heapSort = new HeapSort(data);
    }

    @Test
    public void testHeapSort() {
        int[] expected = Arrays.copyOf(data, data.length);
        Arrays.sort(expected);
        heapSort.sort();
        for (int i = 0; i < data.length; i++) {
            collector.checkThat("Not sorted", expected[i], equalTo(data[i]));
        }
    }

}
