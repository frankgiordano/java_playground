package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

/**
 * Implement Two Stacks using one Array
 * 
 * author francesco giordano
 */
public class TwoStacks {

    int size;
    int[] arr;
    int stack1Top;
    int stack2Top;

    public TwoStacks(int n) {
        size = n;
        arr = new int[size];
        stack1Top = -1;
        stack2Top = (size / 2);
    }

    public boolean isFullS1() {
        return stack1Top == (size / 2);
    }

    public boolean isFullS2() {
        return stack2Top == size - 1;
    }

    public void push1(int value) {
        if (isFullS1()) { // there's no more space in your stack
            System.err.println("Your Stack is full");
            return;
        }
        arr[++stack1Top] = value;
    }

    public void push2(int value) {
        if (isFullS2()) { // there's no more space in your stack
            System.err.println("Your Stack is full");
            return;
        }
        arr[++stack2Top] = value;
    }

    public int pop1() {
        if (stack1Top != -1) { // not empty
            return arr[stack1Top--];
        } else { // empty
            System.err.println("Stack is Empty");
            return -1;
        }
    }

    public int pop2() {
        if (stack2Top != (size / 2)) { // not empty
            return arr[stack2Top--];
        } else { // empty
            System.err.println("Stack is Empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(5);

        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(stacks.pop1());
        }

        System.out.println();

        stacks.push2(1);
        stacks.push2(2);
        stacks.push2(3);
        stacks.pop2();
        stacks.push2(6);

        for (int i = 0; i < 3; i++) {
            System.out.println(stacks.pop2());
        }
    }

}