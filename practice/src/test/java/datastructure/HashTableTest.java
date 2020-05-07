package datastructure;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashTableTest {

    private static HashTable<String, String> hashTable;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    public void test1InsertAndGet() {
        hashTable.add("Neha", "Karthik");
        hashTable.add("Karthik", "Neha");
        hashTable.add("Lakers", "2020");
        hashTable.add("Lakers", "2021");
        collector.checkThat("Invalid Value", hashTable.get("Neha"), equalTo("Karthik"));
        collector.checkThat("Invalid Value", hashTable.get("Lakers"), equalTo("2021"));
    }

    @Test
    public void test2NonExistentKey() {
        collector.checkThat("Invalid Value", hashTable.get("Neha1"), equalTo(null));
    }

    @Test
    public void test3ExistsRemove() {
        hashTable.remove("Lakers");
        collector.checkThat("Invalid Value", hashTable.exists("Lakers"), equalTo(false));
        hashTable.remove("Lakers1");
    }

}
