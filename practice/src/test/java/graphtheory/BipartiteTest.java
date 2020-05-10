package graphtheory;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

public class BipartiteTest {

    private static Map<Integer, List<Edge>> adjList;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        adjList = new HashMap<>();
        for (int i = 0; i <= 8; i++) {
            adjList.put(i, new ArrayList<>());
        }
        adjList.get(0).add(new Edge(0, 1));
        adjList.get(0).add(new Edge(0, 2));
        adjList.get(1).add(new Edge(1, 3));
        adjList.get(1).add(new Edge(1, 4));
        adjList.get(2).add(new Edge(2, 4));
        adjList.get(2).add(new Edge(2, 5));
        adjList.get(3).add(new Edge(3, 6));
        adjList.get(4).add(new Edge(4, 6));
        adjList.get(4).add(new Edge(4, 7));
        adjList.get(5).add(new Edge(5, 7));
        adjList.get(6).add(new Edge(6, 8));
        adjList.get(7).add(new Edge(7, 8));
        adjList.get(8).add(new Edge(8, 1));
    }

    @Test
    public void test() {
        collector.checkThat("Graph not bipartite", Bipartite.isBipartite(adjList), equalTo(true));
    }
}
