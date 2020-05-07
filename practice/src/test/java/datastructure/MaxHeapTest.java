package datastructure;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaxHeapTest {

    private static MaxHeap maxHeap;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        maxHeap = new MaxHeap();
    }

    @Test
    public void test1InsertAndGet() {
        collector.checkThat("maxHeap not empty", maxHeap.getSize(), equalTo(0));
        collector.checkThat("maxHeap should be empty", maxHeap.isEmpty(), equalTo(true));
        insertValues();
        collector.checkThat("maxHeap shouldn't be empty", maxHeap.isEmpty(), equalTo(false));
        collector.checkThat("Invalid maxHeap size", maxHeap.getSize(), equalTo(16));
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(89));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2ExtractAndRemove() {
        collector.checkThat("Invalid max value", maxHeap.extractMax(), equalTo(89));
        collector.checkThat("Invalid maxHeap size", maxHeap.getSize(), equalTo(15));

        maxHeap.remove(9);
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(80));
        maxHeap.remove(0);
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(73));
        maxHeap.remove(3);
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(73));
        maxHeap.remove(2);
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(73));

        collector.checkThat("Invalid maxHeap size", maxHeap.getSize(), equalTo(11));

        maxHeap.insert(82);
        collector.checkThat("Invalid max value", maxHeap.getMax(), equalTo(82));

        collector.checkThat("Invalid maxHeap size", maxHeap.getSize(), equalTo(12));

        maxHeap.remove(100);
    }

    private void insertValues() {
        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(45);
        maxHeap.insert(80);
        maxHeap.insert(15);
        maxHeap.insert(2);
        maxHeap.insert(49);
        maxHeap.insert(63);
        maxHeap.insert(34);
        maxHeap.insert(89);
        maxHeap.insert(73);
        maxHeap.insert(55);
        maxHeap.insert(67);
        maxHeap.insert(29);
        maxHeap.insert(44);
        maxHeap.insert(24);
    }
}
