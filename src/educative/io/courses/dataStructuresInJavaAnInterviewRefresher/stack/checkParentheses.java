package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

public class checkParentheses {

    public static boolean isCloseParatheses(char c) {
        return c == ')' ? true : false; 
    }

    public static boolean isCloseClurly(char c) {
        return c == '}' ? true : false; 
    }

    public static boolean isCloseBlock(char c) {
        return c == ']' ? true : false; 
    }

    public static boolean isBalanced(String exp) {

        myStack stack = new myStack(exp.length());
        stack.push(exp.charAt(0));

        for (int i = 0; i < exp.length(); i++) {

            if (stack.isEmpty())
                break;

            char c = exp.charAt(i);
            if (c == ' ')
                continue;

            if (isCloseParatheses(c)) {
                if (stack.pop() != '(') 
                  return false;
                else continue;
            }
            if (isCloseClurly(c)) {
                if (stack.pop() != '{') 
                  return false;
                else continue;
            }
            if (isCloseBlock(c)) {
                if (stack.pop() != '[') 
                  return false;
                else continue;
            }

            stack.push(c);

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "{ [ ( ) ] }";
        System.out.println(isBalanced(s));
    }

}