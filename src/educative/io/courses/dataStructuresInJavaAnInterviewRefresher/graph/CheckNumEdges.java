package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;

public class CheckNumEdges {

    public static int numEdges(myGraph g) {

        int count = 0;

        for (int i = 0; i < g.vertices; i++) {
            Node finger = null;
            if (g.adjacencyList[i] != null && g.adjacencyList[i].headNode != null)
                finger = g.adjacencyList[i].headNode.nextElement;
            while (finger != null) {
                count++;
                finger = finger.nextElement;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        myGraph graph = new myGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println(CheckNumEdges.numEdges(graph));

        myGraph graph2 = new myGraph(6);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);

        System.out.println(CheckNumEdges.numEdges(graph2));

        // this is a undirected graph so this case is false
        myGraph graph3 = new myGraph(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        System.out.println(CheckNumEdges.numEdges(graph3));


        myGraph graph4 = new myGraph(5);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 1);
        graph4.addEdge(4, 2);
        System.out.println(CheckNumEdges.numEdges(graph4));
    }
}