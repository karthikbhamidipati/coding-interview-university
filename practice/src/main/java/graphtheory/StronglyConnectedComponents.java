package graphtheory;

import java.util.*;

public class StronglyConnectedComponents {
    private static final int UNVISITED = -1;

    private final Map<Integer, List<Edge>> adjList;
    private final int[] low;
    private final int[] ids;
    private final boolean[] onStack;
    private final Stack<Integer> stack;
    private int sccCount;
    private int id;

    public StronglyConnectedComponents(Map<Integer, List<Edge>> adjList) {
        this.adjList = adjList;
        id = 0;
        sccCount = 0;
        low = new int[adjList.size()];
        ids = new int[adjList.size()];
        onStack = new boolean[adjList.size()];
        stack = new Stack<>();
        Arrays.fill(ids, UNVISITED);
        findConnectedComponents();
    }

    private void findConnectedComponents() {
        for (int i = 0; i < adjList.size(); i++) {
            if (ids[i] == UNVISITED) {
                dfs(i);
            }
        }
    }

    private void dfs(int vertex) {
        stack.push(vertex);
        onStack[vertex] = true;
        ids[vertex] = low[vertex] = id++;

        for (Edge edge : adjList.get(vertex)) {
            if (ids[edge.to] == UNVISITED) {
                dfs(edge.to);
            }
            if (onStack[edge.to]) {
                low[vertex] = Math.min(low[edge.to], low[vertex]);
            }
        }

        if (ids[vertex] == low[vertex]) {
            for (int node = stack.pop(); ; node = stack.pop()) {
                onStack[node] = false;
                low[node] = ids[vertex];
                if (node == vertex) {
                    break;
                }
            }
            sccCount++;
        }
    }

    public int getSccCount() {
        return sccCount;
    }

    public Map<Integer, List<Integer>> getConnectedComponents() {
        Map<Integer, List<Integer>> sccComponents = new HashMap<>();
        for (int i = 0; i < low.length; i++) {
            if (!sccComponents.containsKey(low[i])) {
                sccComponents.put(low[i], new ArrayList<>(i));
            }
            sccComponents.get(low[i]).add(i);
        }
        return sccComponents;
    }
}
