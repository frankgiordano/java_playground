package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

import java.util.Stack;

/**
 * Sort values in Stack
 * 
 * author Francesco Giordano
 */
public class SortStackV2 {

    public static Stack<Integer> sort(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<Integer>();

        // pop from mainStack make it tempValue
        // peek at tempStack and see if tempValue is less than peek of tempStack
        // if so pop from temp stack and push to main stack or else
        // push tempValue and tempStack top back into mainStack

        while (!stack.empty()) {

            Integer tempValue = stack.pop();
            if (tempStack.empty()) {
                tempStack.push(tempValue);
                continue;
            }

            if (tempStack.peek() > tempValue) {
                tempStack.push(tempValue);
            } else {
                stack.push(tempStack.pop());
                stack.push(tempValue);
            }

        }

        return tempStack;
    }

    public static void main(String args[]){
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(2);
        stack.add(97);
        stack.add(4);
        stack.add(42);
        stack.add(12);
        stack.add(60);
        stack.add(23);

        stack = SortStackV2.sort(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}