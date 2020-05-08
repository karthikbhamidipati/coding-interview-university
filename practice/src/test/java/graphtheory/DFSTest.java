package graphtheory;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DFSTest {

    private static Map<Integer, List<Edge>> adjList;
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private int[][] adjMatrix;

    @Before
    public void setUp() {
        adjList = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            adjList.put(i, new ArrayList<>());
        }
        adjList.get(1).add(new Edge(1, 2));
        adjList.get(1).add(new Edge(1, 3));
        adjList.get(1).add(new Edge(1, 4));
        adjList.get(2).add(new Edge(2, 8));
        adjList.get(2).add(new Edge(2, 11));
        adjList.get(3).add(new Edge(3, 5));
        adjList.get(3).add(new Edge(3, 6));
        adjList.get(4).add(new Edge(4, 5));
        adjList.get(5).add(new Edge(5, 6));
        adjList.get(5).add(new Edge(5, 7));
        adjList.get(6).add(new Edge(6, 8));
        adjList.get(6).add(new Edge(6, 9));
        adjList.get(9).add(new Edge(9, 10));
    }

    @Test
    public void test1DfsAdjListRecursion() {
        List<Integer> parseOrder = new ArrayList<>();
        DFS.dfs(adjList, parseOrder, new boolean[adjList.size() + 1], 1);
        collector.checkThat("Invalid parse Order", parseOrder.equals(Arrays.asList(1, 2, 8, 11, 3, 5, 6, 8, 9, 10, 7, 4)), equalTo(true));
    }

    @Test
    public void test2DfsAdjListStack() {
        collector.checkThat("Invalid parse Order", DFS.dfs(adjList, 1).equals(Arrays.asList(1, 4, 5, 7, 6, 9, 10, 8, 3, 2, 11)), equalTo(true));
    }

}
