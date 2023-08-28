package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.graph;

/*
Challenge 7: Check if the Given Graph is a Tree?
Given a graph, can you write a code to check if it is a tree or not?

To check whether an undirected graph is a tree or not, we’ll check the following:

Each node (except root) has exactly one parent
There is no cycle in the graph.
The graph is connected.

We check the first condition in checkOneParent function by traversing the adjacency 
list of the graph. If the first condition is not satisfied we return false and don’t
check further.

For a directed graph, We can use DFS to detect the next two conditions.

To check for cycles, we use the same detectCycle function that was used in challenge 3.
If we come across any vertex that has already been visited and is not the parent of the
current vertex, then there is a cycle. If we do not find such an adjacent for any vertex,
we say that there is no cycle.

Then we check for connectivity in the checkConnected method and traverse all the vertices
on the graph to check if they have been visited from the source. If we find any vertex
that is not visited, we conclude that vertex is not reachable from the source. Therefore,
the graph is not connected and hence, is not a tree.

author: educative.io
*/
public class CheckTree {
    public static boolean isTree(Graph g) {

        // 1. Check each node other than root has exactly one parent.
        if (!checkOneParent(g))
            return false;

        // 2. Check for Cycle
        if (detectCycle(g))
            return false;

        // 3. Check for connectivity
        if (!checkConnected(g, 0))
            return false;

        return true;
    }

    public static boolean detectCycle(Graph g) {
        int num_of_vertices = g.vertices;

        // Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[num_of_vertices];
        // Holds a flag if the node is currently in Stack or not (by default- false)
        boolean[] stackFlag = new boolean[num_of_vertices];

        for (int i = 0; i < num_of_vertices; i++) {
            // Check cyclic on each node
            if (cyclic(g, i, visited, stackFlag)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {
        // if node is currently in stack that means we have found a cycle
        if (stackFlag[v])
            return true;

        // if it is already visited (and not in Stack) then there is no cycle
        if (visited[v])
            return false;

        visited[v] = true;
        stackFlag[v] = true;

        // check adjacency list of the node
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;

        while (temp != null) {
            // run cyclic function recursively on each outgowing path
            if (cyclic(g, temp.data, visited, stackFlag)) {
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[v] = false;

        return false;
    }

    public static boolean checkOneParent(Graph g) {
        int num_of_vertices = g.vertices;
        boolean[] hasOneParent = new boolean[num_of_vertices];

        // traverse adjacency list and mark the nodes which have a parent
        for (int i = 0; i < num_of_vertices; i++) {
            DoublyLinkedList<Integer>.Node tmp = null;
            if (g.adjacencyList[i] != null) {
                tmp = g.adjacencyList[i].headNode;
                while (tmp != null) {
                    if (hasOneParent[tmp.data]) // if a node has more than one parent
                        return false; // then return false
                    hasOneParent[tmp.data] = true;
                    tmp = tmp.nextNode;
                }
            }
        }
        for (int i = 0; i < num_of_vertices; i++) {
            // System.out.print(hasOneParent[i]);
            if (i == 0 && hasOneParent[i] == true) {
                // root should not have parent
                return false;
            } else if (i != 0 && hasOneParent[i] == false) {
                // will be false if the node had no parent.
                return false;
            }
        }

        return true;
    }

    private static boolean checkConnected(Graph g, int source) {

        int num_of_vertices = g.vertices;
        int vertices_reached = 0; // Store vertices reachable through source

        // Boolean Array to hold the history of visited nodes (by default-false)
        // Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[num_of_vertices];

        // Create Stack(Implemented in previous section) for Depth First Traversal and
        // Push source in it
        Stack<Integer> stack = new Stack<>(num_of_vertices);

        stack.push(source);
        visited[source] = true;

        // Traverse while stack is not empty
        while (!stack.isEmpty()) {

            // Pop a vertex/node from stack
            int current_node = stack.pop();

            // Get adjacent vertices to the current_node from the array,
            // and push unvisited vertices in stack and also increment vertices_reached
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    stack.push(temp.data);
                    visited[temp.data] = true;
                    vertices_reached++;
                }

                temp = temp.nextNode;
            }

        }

        // +1 for source, and if number of vertices reachable from source are equal
        // to the total number of vertices in graph then return true else false.
        return (vertices_reached + 1) == g.vertices;
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        Graph g3 = new Graph(6);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(4, 5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }
}