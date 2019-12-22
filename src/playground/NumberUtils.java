package playground;

/* 
Take a string with leading alpha characters and trailing numbers and 
produce a string of the number + 1. 

This was work related and prototype for a method to accomplish a similar task. 

author: francesco giordano
*/
public class NumberUtils {

    public static String numPlusOne(String str) {

        int currNum = 0;
        String newNum = "";

        int index = str.length() - 1;
        char c = str.charAt(index);
        while (c >= '0' && c <= '9') {
            c = str.charAt(--index);
        }

        for (int i = index+1; i < str.length(); i++) 
            currNum = currNum * 10 + Character.getNumericValue(str.charAt(i));

        newNum = String.valueOf(currNum+1);

        if (currNum < 9) 
            return "0" + newNum;
        else 
            return newNum;
    }

    public static void main(String args[]) {
        System.out.println(NumberUtils.numPlusOne("d1411"));
    }

}