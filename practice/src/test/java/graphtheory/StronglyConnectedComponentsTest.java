package graphtheory;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StronglyConnectedComponentsTest {

    private static StronglyConnectedComponents scc1;
    private static StronglyConnectedComponents scc2;

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

        scc1 = new StronglyConnectedComponents(adjList);
    }

    @Test
    public void test1scc() {
        collector.checkThat("Invalid Count", scc1.getSccCount(), equalTo(5));
        Map<Integer, List<Integer>> components = scc1.getConnectedComponents();
        collector.checkThat("Invalid Components", components.get(0), equalTo(Collections.singletonList(0)));
        collector.checkThat("Invalid Components", components.get(1), equalTo(Arrays.asList(1, 2, 3)));
        collector.checkThat("Invalid Components", components.get(3), equalTo(Collections.singletonList(4)));
        collector.checkThat("Invalid Components", components.get(4), equalTo(Collections.singletonList(5)));
        collector.checkThat("Invalid Components", components.get(6), equalTo(Collections.singletonList(6)));
    }
}
