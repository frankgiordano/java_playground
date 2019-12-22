package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
* Challenge 1 : Remove Even Integers from Array
*
* Given an array of size n, remove all even integers from it.
*
* author: francesco giordano
*/
public class CheckRemoveEven {

    public static int[] checkRemoveEven(int[] array) {

        if (array == null) 
            return null;

        int oddElements = 0;

        for (int i = 0; i < array.length; i++) 
            if (array[i] % 2 == 0)
                oddElements++; 

        int[] result = new int[oddElements];

        int totalCount = 0;
        int evenCount = 0;
        for (int num: array) {
            if (num % 2 == 0) {
                result[evenCount++] = array[totalCount];
            }
            totalCount++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 2, 3, 4, 5, 9, 8};
        data = CheckRemoveEven.checkRemoveEven(data);
        for (int num: data) 
            System.out.println(num);
    }

}




