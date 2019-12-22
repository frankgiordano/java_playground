package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * undirected graph
 * 
 * this class uses java's map and arraylist to represent the graph instead of custom build array and linked list from the
 * other example..
 * 
 * author: francesco giordano
 */

public class GraphAdjacencyList {
    private Map<Integer, ArrayList<Integer>> adjListMap;
    public int number_of_vertices;

    public GraphAdjacencyList(int vertices) {
        this.number_of_vertices = vertices;
        adjListMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adjListMap.put(i, new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {      
        int size = number_of_vertices - 1; 
        if (source > size || destination > size)
            return;

        adjListMap.get(source).add(destination);
        // the following makes it undirected.. 
        adjListMap.get(destination).add(source);
    }

    public ArrayList<Integer> getNeighbors(int vertice) {
        int size = number_of_vertices - 1; 
        if (vertice > size)
            return null;
        return this.adjListMap.get(vertice);
    }

    public static void main(String[] args) {

        GraphAdjacencyList graph = new GraphAdjacencyList(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 6);

        System.out.println("The given adjacency list for the graph");
        for (int i = 0; i < graph.number_of_vertices; i++) {
            System.out.print(i + "=>");
            ArrayList<Integer> edges = graph.getNeighbors(i);
            for (Integer edge: edges) {
                System.out.print(edge);
            }
            System.out.println();
        }
    }

}