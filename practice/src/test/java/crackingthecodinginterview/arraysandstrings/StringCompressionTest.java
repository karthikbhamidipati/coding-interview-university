package crackingthecodinginterview.arraysandstrings;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

public class StringCompressionTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private static StringCompression obj;

    @BeforeClass
    public static void setup() {
        obj = new StringCompression();
    }

    @Test
    public void testEmptyString() {
        collector.checkThat("Invalid output!!!", obj.compress(""), equalTo(""));
        collector.checkThat("Invalid output!!!", obj.compress(null), equalTo(null));
    }

    @Test
    public void testSmallString() {
        collector.checkThat("Invalid output!!!", obj.compress("aa"), equalTo("aa"));
        collector.checkThat("Invalid output!!!", obj.compress("ab"), equalTo("ab"));
    }

    @Test
    public void testCompressibleString() {
        collector.checkThat("Invalid output!!!", obj.compress("aaa"), equalTo("a3"));
        collector.checkThat("Invalid output!!!", obj.compress("aaaaabb"), equalTo("a5b2"));
        collector.checkThat("Invalid output!!!", obj.compress("aaaaabbc"), equalTo("a5b2c1"));
    }

    @Test
    public void testUnCompressibleString() {
        collector.checkThat("Invalid output!!!", obj.compress("aaab"), equalTo("aaab"));
        collector.checkThat("Invalid output!!!", obj.compress("aaabbcd"), equalTo("aaabbcd"));
    }
}
