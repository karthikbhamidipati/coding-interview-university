package graphtheory;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DjikstraTest {

    private static Djikstra djikstra;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        Map<Integer, List<Edge>> adjList = new HashMap<>();
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

        djikstra = new Djikstra(adjList, 0);
    }

    @Test
    public void testShortestPath() {
        System.out.println(djikstra.getShortestPath(0));
        System.out.println(djikstra.getShortestPath(1));
        System.out.println(djikstra.getShortestPath(2));
        System.out.println(djikstra.getShortestPath(3));
        System.out.println(djikstra.getShortestPath(4));
        System.out.println(djikstra.getShortestPath(5));
        System.out.println(djikstra.getShortestPath(6));
    }
}
