package playground;

/*
Find the next higher number using the digits in the given number e.g. 53625 
the next should be 53652  
*/
public class NextHighest {

    public static int solution(int num) {
        int result = 0;

        int numCopy = num;
        int length = 0;
        while (numCopy > 0) {
            numCopy = numCopy / 10;
            length++;
        }

        int[] numbers = new int[length];

        numCopy = num;
        for (int i = length-1; i >= 0; i--) {
            int value = numCopy % 10;
            numCopy = numCopy / 10;
            numbers[i] = value;
        }

        int endIndex = length - 1;
        int aheadEndIndex = length - 2;
        while (aheadEndIndex >= 0) {
            if (numbers[endIndex] < numbers[aheadEndIndex]) {
                int tmp = numbers[aheadEndIndex];
                numbers[aheadEndIndex] = numbers[endIndex];
                numbers[endIndex] = tmp;
            }
            endIndex--;
            aheadEndIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(NextHighest.solution(21354));
    }

}
