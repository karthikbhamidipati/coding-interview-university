package searching;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinarySearchTest {

    private static BinarySearch binarySearch;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void test1LoopOddSizeArray() {
        int[] sorted = {1, 2, 3, 4, 5};
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 1), equalTo(0));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 2), equalTo(1));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 3), equalTo(2));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 4), equalTo(3));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 5), equalTo(4));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 6), equalTo(-1));
    }

    @Test
    public void test2LoopEvenSizeArray() {
        int[] sorted = {1, 2, 3, 4, 5, 6};
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 1), equalTo(0));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 2), equalTo(1));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 3), equalTo(2));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 4), equalTo(3));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 5), equalTo(4));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 6), equalTo(5));
        collector.checkThat("Incorrect index", binarySearch.search(sorted, 0), equalTo(-1));
    }

    @Test
    public void test3RecursionOddSizeArray() {
        int[] sorted = {1, 2, 3, 4, 5};
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 1, 0, sorted.length - 1), equalTo(0));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 2, 0, sorted.length - 1), equalTo(1));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 3, 0, sorted.length - 1), equalTo(2));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 4, 0, sorted.length - 1), equalTo(3));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 5, 0, sorted.length - 1), equalTo(4));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 6, 0, sorted.length - 1), equalTo(-1));
    }

    @Test
    public void test4RecursionEvenSizeArray() {
        int[] sorted = {1, 2, 3, 4, 5, 6};
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 1, 0, sorted.length - 1), equalTo(0));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 2, 0, sorted.length - 1), equalTo(1));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 3, 0, sorted.length - 1), equalTo(2));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 4, 0, sorted.length - 1), equalTo(3));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 5, 0, sorted.length - 1), equalTo(4));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 6, 0, sorted.length - 1), equalTo(5));
        collector.checkThat("Incorrect index", binarySearch.searchWithRecursion(sorted, 0, 0, sorted.length - 1), equalTo(-1));
    }

}
