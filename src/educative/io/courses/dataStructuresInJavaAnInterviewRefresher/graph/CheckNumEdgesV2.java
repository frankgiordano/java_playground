package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import java.util.ArrayList;

public class CheckNumEdgesV2 {

    public static int numEdges(GraphAdjacencyList g) {

        int count = 0;

        for (int i = 0; i < g.number_of_vertices; i++) {
            ArrayList<Integer> edges = g.getNeighbors(i);

            count = count + edges.size();
        }

        // graph is undirect hence divide by 2
        return count/2;
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        System.out.println(CheckNumEdgesV2.numEdges(graph));

        GraphAdjacencyList graph2 = new GraphAdjacencyList(6);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 4);
        graph2.addEdge(2, 5);

        System.out.println(CheckNumEdgesV2.numEdges(graph2));

        // this is a undirected graph so this case is false
        GraphAdjacencyList graph3 = new GraphAdjacencyList(3);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        System.out.println(CheckNumEdgesV2.numEdges(graph3));


        GraphAdjacencyList graph4 = new GraphAdjacencyList(5);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 1);
        graph4.addEdge(4, 2);
        System.out.println(CheckNumEdgesV2.numEdges(graph4));
    }

}