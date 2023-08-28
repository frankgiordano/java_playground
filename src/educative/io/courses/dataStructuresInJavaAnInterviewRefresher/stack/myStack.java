package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

public class myStack {

    public int size;
    private int[] stackArray;
    private int top;

    // Stack Constructor
    public myStack(int s) { // takes size as a parameter
        stackArray = new int[s]; // allocate memory for the array
        size = s;
        top = -1; // when the stack is empty initially
    }

    // Return top element
    public int top() {
        if (!isEmpty()) { // not empty
            return stackArray[top];
        } else { // empty
            System.err.println("Stack is Empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return top == -1; // returns true if top == -1, stack is empty
    }

    public boolean isFull() {
        return top == size - 1; // returns true if stack is filled upto (size - 1)
    }

    // Inserts the element at top
    public void push(int value) {
        if (isFull()) { // there's no more space in your stack
            System.err.println("Your Stack is full");
            return;
        }
        stackArray[++top] = value; // adds value to the stack and updates the top element
    }

    // Removes and returns the element at top
    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--]; // returns the most recent element added, and updates the value of the top
            // element
        } else { // no element present in the stack to return
            System.err.println("Your Stack is empty");
            return -1;
        }
    }

    public static void main(String[] args) {

        myStack stack = new myStack(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i); // pushes 5 elements (0-4 inclusive) to the stack
        }

        System.out.println("Is Stack full? \n" + stack.isFull());

        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " "); // pops all 5 elements from the stack and prints them
        }

        System.out.println("\nIs Stack empty? \n" + stack.isEmpty());
    }
}