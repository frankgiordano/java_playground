package leetcode;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.isEmpty() || s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpen(c)) {
                stack.add(c);
                continue;
            }

            if (isClose(c) && !stack.isEmpty()) {
                char top = stack.pop();
                if (returnCloseVersion(top) != c)
                    return false;
            } else {
                return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    private static boolean isOpen(char c) {
        if (c == '(' || c == '{' || c == '[')
            return true;
        return false;
    }

    private static boolean isClose(char c) {
        if (c == ')' || c == '}' || c == ']')
            return true;
        return false;
    }

    private static Character returnCloseVersion(char c) {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return c;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()))"));
    }

}
