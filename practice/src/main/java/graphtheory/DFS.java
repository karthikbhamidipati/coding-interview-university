package graphtheory;

import datastructure.Queue;
import datastructure.QueueUsingLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS {
    public static void dfs(Map<Integer, List<Edge>> adjList, List<Integer> parseOrder, boolean[] visited, int start) {
        List<Edge> edges = adjList.get(start);
        parseOrder.add(start);
        for (Edge edge : edges) {
            if (!visited[edge.to]) {
                visited[start] = true;
                dfs(adjList, parseOrder, visited, edge.to);
            }
        }
    }

    public static List<Integer> dfs(Map<Integer, List<Edge>> adjList, int start) {
        List<Integer> parseOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.size() + 1];
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.peek();
            parseOrder.add(vertex);
            List<Edge> edges = adjList.get(vertex);
            visited[vertex] = true;
            stack.pop();
            edges.stream().filter(edge -> !visited[edge.to]).forEach(edge -> stack.push(edge.to));
        }
        return parseOrder;
    }
}
