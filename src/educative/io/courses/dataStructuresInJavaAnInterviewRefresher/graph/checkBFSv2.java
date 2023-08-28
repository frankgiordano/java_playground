package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a BFS traversal of a graph structure
 * <p>
 * Using GraphAdjacencyList class implementation
 * <p>
 * author Francesco Giordano
 */
public class checkBFSv2 {

    public static String checkBFS(int source, GraphAdjacencyList graph) {
        String result = "";
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[graph.number_of_vertices];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int curr_val = queue.remove();
            result += String.valueOf(curr_val);

            ArrayList<Integer> edges = graph.getNeighbors(curr_val);

            for (Integer edge : edges) {
                if (!visited[edge]) {
                    queue.add(edge);
                    visited[edge] = true;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        System.out.println(checkBFS(1, graph));
    }
}