package leetcode;

public class reverseSentence {

    /*
     * Given an input string, reverse the string word by word.
     * 
     * A word is defined as a sequence of non-space characters. Input string may
     * contain leading or trailing spaces. However, your reversed string should not
     * contain leading or trailing spaces. You need to reduce multiple spaces
     * between two words to a single space in the reversed string.
     * 
     * leetcode = 6ms time, 36.4 MB memory
     */
    public static String reverseWords(String s) {

        // if nothing is sent in return an emptry string
        if (s == null || s.length() == 0)
            return "";

        int i = 0; // this holds the index value of the first char of a word
        int size = s.length(); // this is the size of the entire sentence
        char[] arr = s.toCharArray(); // convert String to char array for easier handling

        for (int j = 0; j < size; j++) { // inspect entire sentence char array

            // look for a space, if found then you may have found a word, reverse the word
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1; // increase i counter to the next word start index
            }
        }

        // at this point the last word has not been handled yet, handle it now
        reverse(arr, i, size - 1);

        // reverse the entire sentence char array
        reverse(arr, 0, size - 1);

        String result = new String(arr);
        result = result.trim().replaceAll(" +", " ");
        return result;
    }

    /*
     * Given an input string, reverse the string word by word.
     * 
     * Input will contain no leading or trailing spaces or multipe spaces
     * 
     * runtime O(n) space O(1)
     */
    public static String reverseWords2(char[] arr) {

        // if nothing is sent in return an emptry string
        if (arr == null || arr.length == 0)
            return "";

        int i = 0; // this holds the index value of the first char of a word
        int size = arr.length; // this is the size of the entire sentence

        for (int j = 0; j < size; j++) { // inspect entire sentence char array

            // look for a space, if found then you may have found a word, reverse the word
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1; // increase i counter to the next word start index
            }
        }

        // at this point the last word has not been handled yet, handle it now
        reverse(arr, i, size - 1);

        // reverse the entire sentence char array
        reverse(arr, 0, size - 1);

        return new String(arr);
    }

    /* 
    Given an input string, reverse the string word by word.

    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.

    leetcode = 3ms time, 38.2 MB MB memory
    */
    public static String reverseWords3(String s) {

        if (s == null || s.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();
        int end = -1;
        int size = arr.length - 1;

        // i variable will hold current index that trasverses the input 
        // end variable uses i to set the current end index value of 
        // the current word 
        int i = size;
        while (i >= 0) {

            if (arr[i] == ' ') {

                if (end != -1) {
                    write(arr, i + 1, end, sb);
                    end = -1;
                }

            } else {
                if (end == -1)
                    end = i;
            }
            
            i--;
        }

        if (end != -1) {
            write(arr, 0, end, sb);
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 1).toString() : "";
    }

    public static void write(char[] array, int start, int end, StringBuilder sb) {
        while (start <= end) {
            sb.append(String.valueOf(array[start++]));
        }
        sb.append(" ");
    }

    public static void reverse(char[] arr, int i, int j) {

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.println(reverseSentence.reverseWords(input));
        System.out.println(reverseSentence.reverseWords3(input));
        input = " Hello World! ";
        System.out.println(reverseSentence.reverseWords(input));
        System.out.println(reverseSentence.reverseWords3(input));
    }
}