package playground;

import java.util.Scanner;

/**
 * Define the method inspectVals() with a Scanner parameter that reads integers from input until -1 is read.
 * The method returns true if all integers read before -1 are even. Otherwise, the function returns false.
 *
 * Ex: If the input is 40 60 30 -1, then the output is:
 * All true
 *
 * @author Frank Giordano
 */
public class AllEven {

    public static String inspectVals() {
        boolean isNotEven = false;
        Scanner input = new Scanner(System.in);

        int x = 1;
        while (x != -1) {
            x = input.nextInt();

            if (x % 2 != 0 && x != -1) {
                if (!isNotEven) {
                    isNotEven = true;
                }
            }
        }
        input.close();

        if (!isNotEven) {
            return "All true";
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println("Give me a number: ");
        System.out.println(inspectVals());
    }

}
