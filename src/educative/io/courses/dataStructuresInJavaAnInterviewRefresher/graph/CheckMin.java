package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue.myQueue;

public class CheckMin {

    public static int findMin(myGraph g, int source, int destination) {

        int result = 0;
        int num_of_vertices = g.vertices;
        myQueue queue = new myQueue(num_of_vertices);
        boolean[] visited = new boolean[num_of_vertices];
        for (int i = 0; i < num_of_vertices; i++)
            visited[i] = false;

        queue.enqueue(source);

        while (!queue.isEmpty()) {
            int value = queue.dequeue();

            if (visited[value] == false) {
                visited[value] = true;
                result++;
                if (value == destination)
                    return result / 2; // undirected graph need to divide by 2
            }

            if (g.adjacencyList[value] == null)
                continue;

            Node finger = g.adjacencyList[value].headNode.nextElement;
            while (finger != null) {
                int data = finger.data;
                if (visited[data] != true)
                    queue.enqueue(finger.data);
                finger = finger.nextElement;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        myGraph g = new myGraph(10);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 5);

        g.printGraph();

        System.out.println(CheckMin.findMin(g, 0, 5));
    }


}