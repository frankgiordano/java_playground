package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.*;

/**
 * Directed Graph data structure
 *
 * This class uses custom built linkedlist to represent the graph.. 
 * 
 * author Francesco Giordano
 */
public class myGraph {

    int vertices; 
    LinkedList[] array;

    public myGraph(int size) {
        vertices = size;
        array = new LinkedList[size];
    }

    public void printGraph() {

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {  // if check due to optimization below
                System.out.print(i + " -> ");
                Node finger = array[i].headNode.nextElement;
                while (finger != null) {
                    System.out.print(finger.data + " -> "); 
                    finger = finger.nextElement;                       
                }
                System.out.println("null");
            }
        }

    }

    public void addEdge(int source, int destination) {
        LinkedList list = array[source];
        // optimization instead of allocating the entire array size in
        // constructor allocate here if and only if it is being used
        if (list == null)
            array[source] = new LinkedList();
        SingleLinkedListOperations.insertAtStart(array[source], destination);
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