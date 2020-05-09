package datastructure;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BiDirHashTableTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private BiDirHashTable<String, Integer> hashTable;

    @Before
    public void setUp() {
        hashTable = new BiDirHashTable<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        hashTable.add("Karthik", 1);
        hashTable.add("Neha", 2);
        hashTable.add("Lakers", 3);

        collector.checkThat("Key doesn't exist", hashTable.keyExists("Karthik"), equalTo(true));
        collector.checkThat("Key exists", hashTable.keyExists("India"), equalTo(false));
        collector.checkThat("Value doesn't exist", hashTable.valueExists(1), equalTo(true));
        collector.checkThat("Value exists", hashTable.valueExists(10), equalTo(false));

        hashTable.remove("Lakers", 3);

        collector.checkThat("Invalid key", hashTable.getKey(1), equalTo("Karthik"));
        collector.checkThat("Invalid key", hashTable.getKey(100), equalTo(null));
        collector.checkThat("Invalid value", hashTable.getValue("Neha"), equalTo(2));
        collector.checkThat("Invalid value", hashTable.getValue("Lakers"), equalTo(null));

        hashTable.add("Karthik", 4);
        collector.checkThat("Invalid key", hashTable.getKey(1), equalTo(null));
        collector.checkThat("Invalid key", hashTable.getKey(4), equalTo("Karthik"));
        collector.checkThat("Invalid Value", hashTable.getValue("Karthik"), equalTo(4));

        hashTable.add("India", 2);
    }
}
