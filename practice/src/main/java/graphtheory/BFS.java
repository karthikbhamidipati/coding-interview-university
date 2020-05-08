package graphtheory;

import datastructure.Queue;
import datastructure.QueueUsingLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BFS {
    public static List<Integer> bfs(Map<Integer, List<Edge>> adjList, int start) {
        List<Integer> parseOrder = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(start);
        visited[start] = true;

        while (!queue.empty()) {
            int vertex = queue.dequeue();
            parseOrder.add(vertex);
            List<Edge> edges = adjList.get(vertex);
            for (Edge edge : edges) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    queue.enqueue(edge.to);
                }
            }
        }
        return parseOrder;
    }

    public static List<Integer> bfs(int[][] adjMatrix, int start) {
        List<Integer> parseOrder = new ArrayList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(start);
        visited[start] = true;

        while (!queue.empty()) {
            int vertex = queue.dequeue();
            parseOrder.add(vertex);
            for (int i = 0; i < adjMatrix[vertex].length; i++) {
                if (adjMatrix[vertex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
        return parseOrder;
    }
}
