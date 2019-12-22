package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.queue;

public class myQueue {

    private int[] queueArray;
    private int size;
    private int front;
    private int back;
    private int numberOfItems;

    public myQueue(int s) {
        size = s;
        queueArray = new int[s];
        front = 0;
        back = -1;
        numberOfItems = 0;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        return numberOfItems == size;
    }

    public int top() {
        return queueArray[front];
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.err.println("Your queue is full!");
            return;
        }
        if (back == size - 1) {
            back = -1;
        }
        queueArray[++back] = value;
        ++numberOfItems;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.err.println("Your queue is empty!");
            return -1;
        }
        int tmp = queueArray[front++];
        if (front == size)
            front = 0;
        numberOfItems--;
        return tmp;
    }

    public int size() {
        return numberOfItems;
    }

    public static void main(String[] args) {
        myQueue queue = new myQueue(5);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(12);
        queue.enqueue(14);

        System.out.println("Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }

}