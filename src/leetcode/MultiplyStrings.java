package leetcode;

/*
https://leetcode.com/problems/multiply-strings/
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and
num2, also represented as a string.

Needed help from https://www.programcreek.com/

author francesco giordano
 */
public class MultiplyStrings {

    public String multiplyStrings(String n1, String n2) {
        // time = O(n + m)

        if (n1 == null || n2 == null) {
            return "";
        } else if (n1.isEmpty() || n2.isEmpty()) {
            return n1.isEmpty() ? n2 : n1;
        } else if (n1.equals("0") || n2.equals("0")) {
            return "0";
        }

        n1 = new StringBuilder(n1).reverse().toString();
        n2 = new StringBuilder(n2).reverse().toString();

        int size = n1.length() + n2.length();
        int[] product = new int[size];
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                product[i + j] = product[i + j] + ((n1.charAt(i) - '0') * (n2.charAt(j) - '0'));
            }
        }

        for (int i = 0; i < size; i++) {
            int num = product[i] % 10;
            int carry = product[i] / 10;
            product[i] = num;
            // result.append(num);
            if ((i + 1) < size)
                product[i + 1] = product[i + 1] + carry;
        }

        // reverse the int array to get th leading zeros to start at index 0
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            int temp = product[i];
            product[i] = product[j];
            product[j] = temp;
        }

        // avoid lead zeros when populating new string result to return
        boolean leadZeroFlag = product[0] == 0;
        for (int i = 0; i < size; i++) {
            if (product[i] == 0 && leadZeroFlag) {
                continue;
            }
            leadZeroFlag = false;
            result.append(product[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiply = new MultiplyStrings();
        System.out.println(multiply.multiplyStrings("123", "456"));
    }

}
