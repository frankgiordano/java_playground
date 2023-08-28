package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;
 
/**
 * Evaluate Postfix Expression using Stack
 * 
 * author: francesco giordano 
 */
public class CheckPostFix {

    public static boolean isDigit(char c) {
        int charValue = c;
        if (charValue >= 48 && charValue <= 57)
            return true;
        return false;
    }

    public static int evaluatePostFix(String exp) {

        int size = exp.length();
        myStack stack = new myStack(size);
    
        char c;
        for (int i = 0; i < size; i++) {
            c = exp.charAt(i);
            if (isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (c == '-') {
                    stack.push(num2 - num1);
                }
                if (c == '+') {
                    stack.push(num2 + num1);
                }
                if (c == '*') {
                    stack.push(num2 * num1);
                }
                if (c == '/') {
                    stack.push(num2 / num1);
                }

            }
        }

        return stack.pop();
    }

    public static void main (String args[]) {
        int result = CheckPostFix.evaluatePostFix("921*-8-4+");
        System.out.println(result);
    }

}