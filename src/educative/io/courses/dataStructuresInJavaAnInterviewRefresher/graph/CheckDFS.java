package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack.myStack;

/**
 * Implement a DFS traversal of a graph structure
 * <p>
 * author Francesco Giordano
 */
public class CheckDFS {

    public static String dfsTraversal(myGraph g, int source) {
        String result = "";
        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[num_of_vertices];

        myStack stack = new myStack(num_of_vertices);

        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {

            int current_node = stack.pop();
            System.out.println("popping = " + current_node);
            result += String.valueOf(current_node);

            Node finger = null;
            if (g.adjacencyList[current_node] != null && g.adjacencyList[current_node].headNode != null)
                finger = g.adjacencyList[current_node].headNode.nextElement;

            while (finger != null) {

                if (!visited[finger.data]) {
                    stack.push(finger.data);
                    visited[current_node] = true;
                }

                finger = finger.nextElement;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        myGraph g = new myGraph(7);
        // g.addEdge(1,2);
        // g.addEdge(1,3);
        // g.addEdge(2,4);
        // g.addEdge(2,5);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(4, 5);

        g.printGraph();
        System.out.println(CheckDFS.dfsTraversal(g, 1));
    }
}