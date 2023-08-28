package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack.myStack;

/**
 * Reversing First k Elements of Queue
 * <p>
 * author Francesco Giordano
 */
public class CheckReverse {

    private static myStack stack = new myStack(5);

    public static void reverseK(myQueue queue, int k) {

        if (queue.isEmpty())
            return;

        for (int i = 0; i < k; i++) {
            stack.push(queue.dequeue());
        }

        for (int i = 0; i < k; i++) {
            queue.enqueue(stack.pop());
        }

        for (int i = 0; i < k; i++) {
            queue.enqueue(queue.dequeue());
        }

    }

    public static void main(String[] args) {
        myQueue queue = new myQueue(10);

        for (int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }

        CheckReverse.reverseK(queue, 5);

        for (int i = 1; i < 11; i++) {
            System.out.print(" " + queue.dequeue());
        }
    }

}