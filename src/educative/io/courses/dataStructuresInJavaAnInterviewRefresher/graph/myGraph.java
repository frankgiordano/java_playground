package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.LinkedList;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.SingleLinkedListOperations;

/**
 * Directed graph data structure
 * <p>
 * This class uses custom built linkedlist to represent the graph..
 * <p>
 * author Francesco Giordano
 */
public class myGraph {

    int vertices;
    LinkedList[] adjacencyList;

    public myGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
    }

    public void addEdge(int source, int destination) {
        LinkedList list = adjacencyList[source];
        // optimization - instead of allocating/initializing the entire adjacencyList array
        // in the constructor allocate here if and only if it is being used
        if (list == null)
            adjacencyList[source] = new LinkedList();
        SingleLinkedListOperations.insertAtStart(adjacencyList[source], destination);
    }

    public void printGraph() {

        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i] != null) {  // if check due to optimization below
                System.out.print(i + " -> ");
                Node finger = adjacencyList[i].headNode.nextElement;
                while (finger != null) {
                    System.out.print(finger.data + " -> ");
                    finger = finger.nextElement;
                }
                System.out.println("null");
            }
        }

    }

    public static void main(String[] args) {
        myGraph g = new myGraph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        g.printGraph();
    }

}