package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implement a DFS traversal of a graph structure
 * 
 * Using GraphAdjacencyList class implementation
 * 
 * author Francesco Giordano
 */
public class CheckDFSv2 {

    public static String CheckDFS(int source, GraphAdjacencyList graph) {
        String result = "";
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.number_of_vertices];

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {

            int curr_val = stack.pop();
            result += String.valueOf(curr_val);

            ArrayList<Integer> edges = graph.getNeighbors(curr_val);

            for (Integer edge: edges) {
                if (!visited[edge]) {
                    stack.push(edge);
                    visited[edge] = true;
                }
            }

        }

        return result;
    } 

    public static void main(String args[]) {
        GraphAdjacencyList graph = new GraphAdjacencyList(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        System.out.println(CheckDFS(1, graph));
    }

}