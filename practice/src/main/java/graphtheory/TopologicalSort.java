package graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {
    public List<Integer> sort(Map<Integer, List<Edge>> adjList) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> topSort = new ArrayList<>();
        boolean[] discovered = new boolean[adjList.size()];
        boolean[] processed = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            stack.push(i);
            dfs(adjList, stack, topSort, discovered, processed);
        }
        return topSort;
    }

    private void dfs(Map<Integer, List<Edge>> adjList, Stack<Integer> stack, List<Integer> topSort, boolean[] discovered, boolean[] processed) {
        int node = stack.pop();
        if (!processed[node]) {
            if (discovered[node]) {
                System.out.println("Cycle Detected at node : " + node);
            } else {
                discovered[node] = true;
                for (Edge edge : adjList.get(node)) {
                    stack.push(edge.to);
                    dfs(adjList, stack, topSort, discovered, processed);
                }
                processed[node] = true;
                topSort.add(node);
            }
        }
    }
}
