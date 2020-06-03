package dailycodingproblem;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

public class DecodeFacebookTest {

    private static DecodeFacebook obj;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setup() {
        obj = new DecodeFacebook();
    }

    @Test
    public void test() {
        collector.checkThat("Wrong output", obj.ways("0"), equalTo(0));
        collector.checkThat("Wrong output", obj.ways("1"), equalTo(1));
        collector.checkThat("Wrong output", obj.ways("1262"), equalTo(3));
        collector.checkThat("Wrong output", obj.ways("26"), equalTo(2));
        collector.checkThat("Wrong output", obj.ways("127"), equalTo(2));
        collector.checkThat("Wrong output", obj.ways("1270"), equalTo(0));
        collector.checkThat("Wrong output", obj.ways("83778549129"), equalTo(2));
        collector.checkThat("Wrong output", obj.ways("122231131122"), equalTo(120));
        collector.checkThat("Wrong output", obj.ways("122212313113"), equalTo(126));
        collector.checkThat("Wrong output", obj.ways("321121311231"), equalTo(65));
    }

}
