package JetBrainsAcademy;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Write a program that reads two numbers aa and bb from the keyboard and calculates and outputs to the
 * console the arithmetic average of all numbers from the interval [a; b][a;b], which are divisible by 33.
 *
 * In the example below, the arithmetic average is calculated for the numbers on the interval [-5; 12][−5;12].
 * On this interval, there are 66 numbers divisible by 33, namely: -3, 0, 3, 6, 9, 12−3,0,3,6,9,12. Their
 * arithmetic average equals 4.54.5.
 *
 * The program input contains intervals, which always contain at least one number, which is divisible by 33.
 *
 * Remember that the int type cannot contain fractions. Use a double variable to store the precise result
 * of the division.
 *
 * author: frank giordano
 */
public class ArithmeticAverage {

    public static double solution1(String input) throws Exception {
        String[] inputs = input.split(" ");
        int size = inputs.length;

        if (size == 1 || size > 2)
            throw new Exception("Provided a string without two numbers only, try again...");

        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);

        List<Integer> nums = new ArrayList<>();

        int candidate = num1;
        while (candidate <= num2) {
            if (candidate % 3 == 0)
                nums.add(candidate);
            candidate++;
        }

        IntSummaryStatistics stats = nums.stream().mapToInt((x) -> x).summaryStatistics();
        return Double.valueOf(stats.getAverage());
    }

    public static double solution2(String input) throws Exception {
        String[] inputs = input.split(" ");
        int size = inputs.length;

        if (size == 1 || size > 2)
            throw new Exception("Provided a string without two numbers only, try again...");

        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);

        List<Integer> nums = new ArrayList<>();

        int candidate = num1;
        while (candidate <= num2) {
            if (candidate % 3 == 0)
                nums.add(candidate);
            candidate++;
        }

        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        return (double) sum / (double) nums.size();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ArithmeticAverage.solution1("-5 12"));
        System.out.println(ArithmeticAverage.solution2("-5 12"));
        System.out.println(ArithmeticAverage.solution1("3 10"));
        System.out.println(ArithmeticAverage.solution2("3 10"));
        try {
            System.out.println(ArithmeticAverage.solution2("3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(ArithmeticAverage.solution2("3 10 30"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
