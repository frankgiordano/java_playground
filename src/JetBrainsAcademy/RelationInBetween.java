package JetBrainsAcademy;

/**
 * Write a program that reads three integer numbers and prints true if the first number is between the second
 * and the third one (inclusive). Otherwise, it must print false.
 *
 * The last two arguments may not be sorted.
 *
 * author: frank giordano
 */
public class RelationInBetween {

    public static boolean solution1(String input) throws Exception {
        String[] inputs = input.split(" ");

        if (inputs.length > 3 || input.length() <= 2)
            throw new Exception("Enter three values");

        try {
            if (Integer.parseInt(inputs[0]) > 0 &&
                    Integer.parseInt(inputs[1]) > 0 &&
                    Integer.parseInt(inputs[2]) > 0) {
                return false;
            } else if (Integer.parseInt(inputs[0]) > 0 &&
                    Integer.parseInt(inputs[1]) > 0) {
                return false;
            } else if (Integer.parseInt(inputs[0]) > 0 &&
                    Integer.parseInt(inputs[2]) > 0) {
                return false;
            } else if (Integer.parseInt(inputs[0]) > 0) {
                return true;
            } else if (Integer.parseInt(inputs[1]) > 0) {
                return true;
            } else if (Integer.parseInt(inputs[2]) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(RelationInBetween.solution1("1 1 1"));
        System.out.println(RelationInBetween.solution1("4 3 3"));
        System.out.println(RelationInBetween.solution1("4 -3 -3"));
        System.out.println(RelationInBetween.solution1("30 100 20"));
    }

}
