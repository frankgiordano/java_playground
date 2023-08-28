package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

/**
 * Sort values in Stack
 * 
 * author Francesco Giordano
 */
public class SortStack {

    public static void sort(myStack stack, int size){

        myStack tempStack = new myStack(size);

        // pop from mainStack make it tempValue
        // peek at tempStack and see if tempValue is greater than peek of tempStack
        // if so pop from temp stack and push to main stack or else
        // push tempValue and tempStack top back into mainStack

        while (!stack.isEmpty()) {

            int tempValue = stack.pop();
            if (tempStack.isEmpty()) {
                tempStack.push(tempValue);
                continue;
            }

            int top = tempStack.pop();
            if (top < tempValue) {
                tempStack.push(top);
                tempStack.push(tempValue);
            } else {
                stack.push(top);
                stack.push(tempValue);
            }

        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String args[]){

        myStack stack = new myStack(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);

        SortStack.sort(stack, stack.size);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}