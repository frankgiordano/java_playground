package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

public class NewStack {

    private myStack mainStack;
    private myStack minStack;

    public NewStack(int size) {
        mainStack = new myStack(size);
        minStack = new myStack(size);
    }

    // Removes and return value from newStack
    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    // Pushes values into newStack
    public void push(int value) {

        mainStack.push(value);

        if (value > minStack.top() && !minStack.isEmpty())
            minStack.push(minStack.top());
        else
            minStack.push(value);
    }

    // Returns minimum value from newStack in O(1) Time
    public int min() {
        return minStack.top();
    }

    public static void main(String[] args) {
        NewStack stack = new NewStack(5);

        stack.push(5);
        stack.push(2);
        stack.push(4);

        System.out.println(stack.min());
    }

}