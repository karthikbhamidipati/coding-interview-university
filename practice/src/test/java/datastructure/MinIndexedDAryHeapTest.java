package datastructure;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinIndexedDAryHeapTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private static MinIndexedDAryHeap<String, Integer> indexedPriorityQueue;

    @BeforeClass
    public static void setUp() {
        indexedPriorityQueue = new MinIndexedDAryHeap<>(2);
    }

    @Test
    public void test1EmptyQueue() {
        collector.checkThat("Queue must be empty", indexedPriorityQueue.empty(), equalTo(true));
        collector.checkThat("Queue size must be 0", indexedPriorityQueue.size(), equalTo(0));
    }

    @Test
    public void test2Inserts() {
        indexedPriorityQueue.insert("Karthik", 54);
        indexedPriorityQueue.insert("Neha", 32);
        indexedPriorityQueue.insert("India", 22);
        indexedPriorityQueue.insert("Visa", 44);
        collector.checkThat("Queue size must be 4", indexedPriorityQueue.size(), equalTo(4));
        collector.checkThat("Invalid Min Value", indexedPriorityQueue.peekMinValue(), equalTo(22));
        collector.checkThat("Invalid Min Key", indexedPriorityQueue.peekMinKey(), equalTo("India"));
        collector.checkThat("Key: 'Karthik' not found", indexedPriorityQueue.contains("Karthik"), equalTo(true));
        collector.checkThat("Key: 'India' not found", indexedPriorityQueue.valueOf("India"), equalTo(22));
        collector.checkThat("Key: 'Visa' not found", indexedPriorityQueue.valueOf("Visa"), equalTo(44));
        collector.checkThat("Key: 'Karthik' not found", indexedPriorityQueue.valueOf("Neha"), equalTo(32));
    }

    @Test
    public void test3Deletes() {
        indexedPriorityQueue.delete("India");
        collector.checkThat("Queue size must be 3", indexedPriorityQueue.size(), equalTo(3));
        indexedPriorityQueue.insert("UK", 55);
        indexedPriorityQueue.insert("AI", 20);
        collector.checkThat("Queue size must be 5", indexedPriorityQueue.size(), equalTo(5));
    }

    @Test
    public void test4Updates() {
        indexedPriorityQueue.update("UK", 15);
        indexedPriorityQueue.insert("India", 32);
        collector.checkThat("Queue size must be 6", indexedPriorityQueue.size(), equalTo(6));
        collector.checkThat("Invalid Min Key", indexedPriorityQueue.peekMinKey(), equalTo("UK"));
        collector.checkThat("Invalid Min Value", indexedPriorityQueue.peekMinValue(), equalTo(15));
    }

    @Test
    public void test5Poll() {
        collector.checkThat("Invalid Min Key", indexedPriorityQueue.peekMinKey(), equalTo("UK"));
        collector.checkThat("Invalid Min Value", indexedPriorityQueue.pollMinValue(), equalTo(15));
        collector.checkThat("Queue size must be 5", indexedPriorityQueue.size(), equalTo(5));
        collector.checkThat("Invalid Min Key After Polling", indexedPriorityQueue.peekMinKey(), equalTo("AI"));
        collector.checkThat("Invalid Min Value After Polling", indexedPriorityQueue.peekMinValue(), equalTo(20));
    }

    @Test
    public void test6IncreaseDecrease() {
        indexedPriorityQueue.decrease("Karthik", 5);
        indexedPriorityQueue.decrease("Neha", 10);
        indexedPriorityQueue.increase("AI", 50);
        collector.checkThat("Invalid Min Key", indexedPriorityQueue.peekMinKey(), equalTo("Karthik"));
        collector.checkThat("Invalid Min Value", indexedPriorityQueue.peekMinValue(), equalTo(5));
        System.out.println(indexedPriorityQueue.toString());
    }
}
