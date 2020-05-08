package graphtheory;

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

    public static void dfs(int[][] adjMatrix, List<Integer> parseOrder, boolean[] visited, int start) {
        parseOrder.add(start);
        for (int i = 0; i < adjMatrix[start].length; i++) {
            int vertex = adjMatrix[start][i];
            if (vertex != 0 && !visited[i]) {
                visited[start] = true;
                dfs(adjMatrix, parseOrder, visited, i);
            }
        }
    }

    public static List<Integer> dfs(int[][] adjMatrix, int start) {
        List<Integer> parseOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjMatrix.length];
        stack.push(start);
        while (!stack.isEmpty()) {
            int vertex = stack.peek();
            parseOrder.add(vertex);
            visited[vertex] = true;
            stack.pop();
            for (int i = 0; i < adjMatrix[vertex].length; i++) {
                int to = adjMatrix[vertex][i];
                if (to != 0 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        return parseOrder;
    }
}
