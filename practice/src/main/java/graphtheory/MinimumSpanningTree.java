package graphtheory;

import datastructure.MinIndexedDAryHeap;
import util.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinimumSpanningTree {
    public static Tuple2<Integer, List<Edge>> mst(Map<Integer, List<Edge>> adjList) {
        MinIndexedDAryHeap<Integer, Integer> ipq = new MinIndexedDAryHeap<>(2);
        int[] parent = new int[adjList.size()];
        boolean[] visited = new boolean[adjList.size()];
        ipq.insert(0, 0);
        int size = 0;
        List<Edge> edges = new ArrayList<>();
        while (!ipq.empty()) {
            int vertex = ipq.peekMinKey();
            int weight = ipq.pollMinValue();
            visited[vertex] = true;
            size += weight;
            edges.add(new Edge(parent[vertex], vertex, weight));
            for (Edge edge : adjList.get(vertex)) {
                if (!visited[edge.to]) {
                    if (ipq.contains(edge.to)) {
                        if(ipq.valueOf(edge.to) > edge.weight) {
                            ipq.decrease(edge.to, edge.weight);
                        }
                    } else {
                        ipq.insert(edge.to, edge.weight);
                    }
                    parent[edge.to] = edge.from;
                }
            }
        }
        return new Tuple2<>(size, edges);
    }
}
