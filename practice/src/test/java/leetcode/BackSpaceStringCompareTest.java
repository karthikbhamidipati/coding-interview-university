package leetcode;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BackSpaceStringCompareTest {
    
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private BackSpaceStringCompare obj;
    
    @Before
    public void setUp() {
        obj = new BackSpaceStringCompare();
    }
    
    @Test
    public void test() {
        collector.checkThat("Invalid result", obj.backspaceCompare("ab#c", "ad#c"), equalTo(true));
        collector.checkThat("Invalid result", obj.backspaceCompare("ab#c", "ad#c#d#f#d#d#c"), equalTo(true));
        collector.checkThat("Invalid result", obj.backspaceCompare("ab##", "c#d#"), equalTo(true));
        collector.checkThat("Invalid result", obj.backspaceCompare("a##c", "#a#c"), equalTo(true));
        collector.checkThat("Invalid result", obj.backspaceCompare("bxj##tw", "bxo#j##tw"), equalTo(false));
        collector.checkThat("Invalid result", obj.backspaceCompare("a", "b"), equalTo(false));
        collector.checkThat("Invalid result", obj.backspaceCompare("a", "bc#a"), equalTo(false));
        collector.checkThat("Invalid result", obj.backspaceCompare("bc#a", "a"), equalTo(false));
    }
}
