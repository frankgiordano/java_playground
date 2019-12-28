package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack.myStack;

public class Cycle {

    public static boolean detectCycle(int source, myGraph g) {
        boolean result = false;
        myStack stack = new myStack(g.vertices);
        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++)
            visited[i] = false;

        stack.push(source);
        visited[source] = true;

        while(!stack.isEmpty()) {

            int curr_val = stack.pop();

            Node finger = null;
            if (g.adjacencyList[curr_val] != null && g.adjacencyList[curr_val].headNode != null)
                finger = g.adjacencyList[curr_val].headNode.nextElement;

            while (finger != null) {
                int edge = finger.data;

                if (!visited[edge]) {
                    stack.push(edge);
                    visited[edge] = true;
                }
                else {
                    return true;
                }

                finger = finger.nextElement;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        myGraph graph = new myGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println(Cycle.detectCycle(0, graph));

        myGraph graph2 = new myGraph(6);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);

        System.out.println(Cycle.detectCycle(1, graph2));

        // this is a undirected graph so this case is false
        myGraph graph3 = new myGraph(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        System.out.println(Cycle.detectCycle(1, graph3));


        myGraph graph4 = new myGraph(5);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 1);
        graph4.addEdge(4, 2);
        System.out.println(Cycle.detectCycle(1, graph4));
    }
}