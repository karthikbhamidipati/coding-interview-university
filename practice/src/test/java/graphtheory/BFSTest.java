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
public class BFSTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private int[][] adjMatrix;
    private Map<Integer, List<Edge>> adjList;

    @Before
    public void setUpAdjacencyList() {
        adjList = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            adjList.put(i, new ArrayList<>());
        }
        adjList.get(0).add(new Edge(0, 1));
        adjList.get(0).add(new Edge(0, 2));
        adjList.get(0).add(new Edge(0, 3));
        adjList.get(1).add(new Edge(1, 7));
        adjList.get(1).add(new Edge(1, 10));
        adjList.get(2).add(new Edge(2, 4));
        adjList.get(2).add(new Edge(2, 5));
        adjList.get(3).add(new Edge(3, 4));
        adjList.get(4).add(new Edge(4, 5));
        adjList.get(4).add(new Edge(4, 6));
        adjList.get(5).add(new Edge(5, 7));
        adjList.get(5).add(new Edge(5, 8));
        adjList.get(8).add(new Edge(8, 9));
    }

    @Before
    public void setUpAdjacencyMatrix() {
        adjMatrix = new int[11][11];
        adjMatrix[0][1] = 1;
        adjMatrix[0][2] = 1;
        adjMatrix[0][3] = 1;
        adjMatrix[1][7] = 1;
        adjMatrix[1][10] = 1;
        adjMatrix[2][4] = 1;
        adjMatrix[2][5] = 1;
        adjMatrix[3][4] = 1;
        adjMatrix[4][5] = 1;
        adjMatrix[4][6] = 1;
        adjMatrix[5][7] = 1;
        adjMatrix[5][8] = 1;
        adjMatrix[8][9] = 1;
    }

    @Test
    public void test1BFSAdjList() {
        collector.checkThat("Invalid parse order", BFS.bfs(adjList, 0).equals(Arrays.asList(0, 1, 2, 3, 7, 10, 4, 5, 6, 8, 9)), equalTo(true));
    }

    @Test
    public void test2BFSAdjMatrix() {
        collector.checkThat("Invalid parse order", BFS.bfs(adjMatrix, 0).equals(Arrays.asList(0, 1, 2, 3, 7, 10, 4, 5, 6, 8, 9)), equalTo(true));
    }
}
