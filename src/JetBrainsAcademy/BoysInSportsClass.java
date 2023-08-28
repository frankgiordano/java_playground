package JetBrainsAcademy;

/**
 * Suppose there are three boys in a sports class.
 * <p>
 * You need to write a program that checks if the boys are arranged
 * in ascending or descending order by height. The program must read
 * three integer numbers h1, h2, h3 and outputs true or false. If boys
 * have the same height, they are considered as correctly arranged.
 * <p>
 * author: frank giordano
 */
public class BoysInSportsClass {

    private static class Order {

        private boolean ascending = false;
        private boolean descending = false;

        public Order() {
        }

        public boolean isAscending() {
            return ascending;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }

        public boolean isDescending() {
            return descending;
        }

        public void setDescending(boolean descending) {
            this.descending = descending;
        }

    }

    /**
     * Following solution resolves the issue as description in class summary with only at most 3 inputs provided.
     */
    public static String solution1(String input) {
        String[] inputs = input.split(" ");
        int size = inputs.length;

        // edge case only 3 inputs allowed otherwise return error message...
        if (size > 3) return "Too many inputs, at most three allowed, try again...";

        // edge case if inputs has one value only always return true...
        if (size == 1) return "true";

        // if all the same value return true
        int num1 = Integer.parseInt(inputs[0]), num2 = Integer.parseInt(inputs[1]), num3 = Integer.parseInt(inputs[2]);
        if ((num1 == num2) && (num1 == num3))
            return "true";

        // at least one value is different find its index to determine order
        int indexOfSecondDifferentValue;
        if (num1 != num2)
            indexOfSecondDifferentValue = 1;
        else indexOfSecondDifferentValue = 2;

        // determine order
        Order order = new Order();
        determineOrder(order, inputs, indexOfSecondDifferentValue);

        for (int i = 0, j = i + 1; i < size - 1; i++, j++) {
            int valueOfiIndex = Integer.parseInt(inputs[i]), valueOfjIndex = Integer.parseInt(inputs[j]);
            if ((order.isAscending() && (valueOfiIndex <= valueOfjIndex)) ||
                    (order.isDescending() && valueOfiIndex >= valueOfjIndex)) continue;
            return "false";
        }

        return "true";
    }

    /**
     * Following solution resolves the issue as described in class summary with handling a large amount of inputs.
     */
    public static String solution2(String input) {
        String[] inputs = input.split(" ");
        int size = inputs.length;

        // edge case if inputs are only at most 2 values then always return true
        if (size == 1 || size == 2) {
            return "true";
        }

        // edge case check to make sure the rest of values are not all the same value if all same return true
        // if not same get index of first value that is different from first value that will be used to
        // determine ordering...
        String firstValue = inputs[0];
        boolean same = true;
        int indexOfSecondDifferentValue = 0;
        for (int i = 1; i < size; i++) {
            int num1 = Integer.parseInt(firstValue), num2 = Integer.parseInt(inputs[i]);
            if (num1 != num2) {
                same = false;
                indexOfSecondDifferentValue = i;
                break;
            }
        }
        if (same) return "true";

        // determine order
        Order order = new Order();
        determineOrder(order, inputs, indexOfSecondDifferentValue);

        for (int i = 0, j = i + 1; i < size - 1; i++, j++) {
            int valueOfiIndex = Integer.parseInt(inputs[i]), valueOfjIndex = Integer.parseInt(inputs[j]);
            if ((order.isAscending() && (valueOfiIndex <= valueOfjIndex)) ||
                    (order.isDescending() && valueOfiIndex >= valueOfjIndex)) continue;
            return "false";
        }

        return "true";
    }

    private static void determineOrder(Order order, String[] inputs, int index) {
        int v1 = Integer.parseInt(inputs[0]), v2 = Integer.parseInt(inputs[index]);
        if (v1 > v2) order.setDescending(true);
        else order.setAscending(true);
    }

    public static void main(String[] args) {
        System.out.println(BoysInSportsClass.solution1("165 165 158"));
        System.out.println(BoysInSportsClass.solution1("165 165 158 165"));
        System.out.println(BoysInSportsClass.solution1("165 165 158 155"));
        System.out.println(BoysInSportsClass.solution1("165 165 168"));
        System.out.println(BoysInSportsClass.solution1("165 144 120"));
        System.out.println();
        System.out.println(BoysInSportsClass.solution2("165 165 158"));
        System.out.println(BoysInSportsClass.solution2("165 165 158 165"));
        System.out.println(BoysInSportsClass.solution2("165 165 158 155"));
        System.out.println(BoysInSportsClass.solution2("165 165 168"));
        System.out.println(BoysInSportsClass.solution2("165 144 120"));
    }

}
