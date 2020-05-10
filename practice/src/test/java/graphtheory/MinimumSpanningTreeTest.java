package graphtheory;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import util.Tuple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

public class MinimumSpanningTreeTest {

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
    public void test() {
        Tuple2<Integer, List<Edge>> mst = MinimumSpanningTree.mst(adjList);
        collector.checkThat("Invalid MST Weight : ", mst.getKey(), equalTo(10));
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 0, 0));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(2, 1, 3));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(4, 5, 1));
        collector.checkThat("Invalid MST : ", mst.getValue(), equalTo(edges));
    }
}
