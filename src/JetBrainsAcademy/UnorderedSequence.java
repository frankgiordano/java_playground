package JetBrainsAcademy;

import java.util.Scanner;

/**
 * Write a program that reads a sequence of integer numbers and outputs true if the sequence is ordered
 * (in ascending or descending order), otherwise, false.
 * <p>
 * Keep in mind, if a number has the same value as the following number, it does not break the order.
 * The sequence ends with 0. Do not consider this number as a part of the sequence. The sequence always
 * has at least one number (excluding 0).
 * <p>
 * Sample Input 1:
 * <p>
 * 9 8 7 6 5 4 3 2 1 0
 * Sample Output 1:
 * <p>
 * true
 * Sample Input 2:
 * <p>
 * 1 2 3 3 9 0
 * Sample Output 2:
 * <p>
 * true
 * Sample Input 3:
 * <p>
 * 1 2 5 5 2 3 0
 * Sample Output 3:
 * <p>
 * false
 * <p>
 * author: frank giordano
 */
public class UnorderedSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int size = inputs.length;

        // edge case
        if (size == 1) {
            System.out.println("true");
            return;
        }

        int nums[] = new int[size];

        for (int i = 0; i < size; i++) {
            try {
                nums[i] = Integer.parseInt(inputs[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number specified, try again...");
                return;
            }
        }

        // edge case
        if (size == 2 && nums[1] == 0) {
            System.out.println("true");
            return;
        }

        int previousInt = nums[0];
        boolean ascending = previousInt < nums[1];
        boolean descending = previousInt > nums[1];
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) break;
            if (ascending && !(previousInt <= nums[i])) {
                System.out.println("false");
                return;
            } else if (descending && !(previousInt >= nums[i])) {
                System.out.println("false");
                return;
            }
            previousInt = nums[i];
        }

        System.out.println("true");
    }

}
