package graphtheory;

import datastructure.MinIndexedDAryHeap;
import util.Tuple2;

import java.util.*;

public class Djikstra {
    private final Map<Integer, List<Edge>> adjList;
    private final MinIndexedDAryHeap<Integer, Integer> indexPriorityQueue;

    private final Integer[] parent;
    private final int[] dist;
    private final boolean[] visited;
    private final int start;

    public Djikstra(Map<Integer, List<Edge>> adjList, int start) {
        this.adjList = adjList;
        this.start = start;
        indexPriorityQueue = new MinIndexedDAryHeap<>(4);
        parent = new Integer[adjList.size()];
        dist = new int[adjList.size()];
        visited = new boolean[adjList.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        calculateShortestPath();
    }

    private void calculateShortestPath() {
        indexPriorityQueue.insert(start, 0);
        dist[start] = 0;
        while (!indexPriorityQueue.empty()) {
            int key = indexPriorityQueue.peekMinKey();
            int value = indexPriorityQueue.pollMinValue();
            visited[key] = true;
            for (Edge edge : adjList.get(key)) {
                if (visited[edge.to]) {
                    continue;
                }
                int newDist = value + edge.weight;
                if (newDist < dist[edge.to]) {
                    parent[edge.to] = key;
                    dist[edge.to] = newDist;
                    if (indexPriorityQueue.contains(edge.to)) {
                        indexPriorityQueue.decrease(edge.to, newDist);
                    } else {
                        indexPriorityQueue.insert(edge.to, newDist);
                    }
                }
            }
        }
    }

    public Tuple2<List<Integer>, Integer> getShortestPath(int end) {
        List<Integer> path = new ArrayList<>();
        for (Integer i = end; i != null; i = parent[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        if (path.get(0) == start) {
            return new Tuple2<>(path, dist[end]);
        } else {
            return new Tuple2<>(new ArrayList<>(), null);
        }
    }

}
