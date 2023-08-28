package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack.myStack;

/**
 * Implement Queue using Stack
 * <p>
 * author francesco giordano
 */
public class NewQueue {

    private educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack.myStack mainStack;
    private myStack tempStack;

    public NewQueue(int size) {
        // Can use size from argument to create stack
        mainStack = new myStack(size);
        tempStack = new myStack(size);
    }

    // Inserts Element in the Queue
    public void enQueue(int value) {
        mainStack.push(value);
    }

    // Removes and Returns Element From Queue
    public int deQueue() {
        int result = Integer.MIN_VALUE;

        if (mainStack.isEmpty())
            return result;

        while (!mainStack.isEmpty())
            tempStack.push(mainStack.pop());

        if (!tempStack.isEmpty())
            result = tempStack.pop();

        while (!tempStack.isEmpty())
            mainStack.push(tempStack.pop());
        return result;
    }

    public static void main(String args[]) {
        NewQueue queue = new NewQueue(10);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        for (int i = 0; i < 4; i++) {
            System.out.println(queue.deQueue());
        }
    }

}