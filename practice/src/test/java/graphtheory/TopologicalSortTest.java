package graphtheory;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.*;

import static org.hamcrest.core.IsEqual.equalTo;


public class TopologicalSortTest {

    private static Map<Integer, List<Edge>> adjList;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        adjList = new HashMap<>();
        for (int i = 0; i <= 6; i++) {
            adjList.put(i, new ArrayList<>());
        }
        adjList.get(0).add(new Edge(0, 1, 5));
        adjList.get(0).add(new Edge(0, 2, 1));
        adjList.get(1).add(new Edge(1, 2, 2));
        adjList.get(1).add(new Edge(1, 3, 3));
        adjList.get(1).add(new Edge(1, 4, 20));
        adjList.get(2).add(new Edge(2, 1, 3));
        adjList.get(2).add(new Edge(2, 4, 12));
        adjList.get(3).add(new Edge(3, 2, 3));
        adjList.get(3).add(new Edge(3, 4, 2));
        adjList.get(3).add(new Edge(3, 5, 6));
        adjList.get(4).add(new Edge(4, 5, 1));
    }

    @Test
    public void testTopSort() {
        List<Integer> topSortOrder = new TopologicalSort().sort(adjList);
        List<Integer> expected = Arrays.asList(5, 4, 2, 3, 1, 0, 6);
        collector.checkThat("TopSort Not as expected", topSortOrder, equalTo(expected));
    }
}
