package graphtheory;

import datastructure.Queue;
import datastructure.QueueUsingArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Bipartite {

    public static boolean isBipartite(Map<Integer, List<Edge>> adjList) {
        Colour[] colours = new Colour[adjList.size()];
        Queue<Integer> queue = new QueueUsingArrays<>();
        Arrays.fill(colours, Colour.UNCOLOURED);
        for (int i = 0; i < adjList.size(); i++) {
            if (colours[i] == Colour.UNCOLOURED) {
                colours[i] = Colour.RED;
                queue.enqueue(i);
                return bfs(adjList, queue, colours);
            }
        }
        return true;
    }

    private static boolean bfs(Map<Integer, List<Edge>> adjList, Queue<Integer> queue, Colour[] colours) {
        while (!queue.empty()) {
            int vertex = queue.dequeue();
            for (Edge edge : adjList.get(vertex)) {
                if (colours[edge.to] == colours[vertex]) {
                    return false;
                } else if (colours[edge.to] == Colour.UNCOLOURED) {
                    colours[edge.to] = invertColours(colours[vertex]);
                    queue.enqueue(edge.to);
                }
            }
        }
        return true;
    }

    private static Colour invertColours(Colour colour) {
        switch (colour) {
            case RED:
                return Colour.BLUE;
            case BLUE:
            default:
                return Colour.RED;
        }
    }

    private enum Colour {
        RED,
        BLUE,
        UNCOLOURED
    }
}
