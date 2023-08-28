package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Cycle Detection in the Graph
 *
 * authro francesco giordano
 */

public class CycleV2 {

    public static boolean detectCycle(int source, GraphAdjacencyList graph) {

        boolean result = false;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.number_of_vertices];
        ArrayList<Integer> edges;

        for (int i = 0; i < graph.number_of_vertices; i++)
            visited[i] = false;

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {

            int curr_val = stack.pop();

            edges = graph.getNeighbors(curr_val);
            for (Integer edge : edges) {
                if (edge == source) {
                    result = true;
                    break;
                }
                if (!visited[edge]) {
                    stack.push(edge);
                    visited[edge] = true;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println(CycleV2.detectCycle(0, graph));

        GraphAdjacencyList graph2 = new GraphAdjacencyList(6);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);

        System.out.println(CycleV2.detectCycle(1, graph2));

        // this is a undirected graph so this case is true
        GraphAdjacencyList graph3 = new GraphAdjacencyList(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        System.out.println(CycleV2.detectCycle(1, graph3));

    }
}