package JavaCodingProblems.StringNumbersMath;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 3. Reversing letters and words
 */
public class ReverseLettersAndWords {

    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String solution1(String str) {

        String[] words = str.split(" ");
        StringBuilder reverseString = new StringBuilder();

        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder(); 
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord.append(word.charAt(j));
            }
            reverseString.append(reverseWord + " ");
        }

        return reverseString.toString();
    }

    // java 8 style!
    public static String solution2(String str) {
        return PATTERN.splitAsStream(str)  // split string and stream the words
                    .map(w -> new StringBuilder(w).reverse())  // for each word reverse it
                    .collect(Collectors.joining(" ")); // take the map result and append to collection string
    }

    /// even shortly and this one reserves the order of the words..
    public static String solution3(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // old style with order reserved too.. 
    public static String solution4(String str) {

        String[] words = str.split(" ");
        StringBuilder reverseString = new StringBuilder();
        String[] reverseWords = new String[words.length];

        int index = words.length - 1;
        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder(); 
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord.append(word.charAt(j));
            }
            reverseWords[index--] = reverseWord.toString();
        }

        for (String word: reverseWords) {
            reverseString.append(word + " ");
        }

        return reverseString.toString();
    }


    public static void main(String[] args) {

        String input = "Frank Giordano is hacking";

        System.out.println(ReverseLettersAndWords.solution1(input));
        System.out.println(ReverseLettersAndWords.solution2(input));
        System.out.println(ReverseLettersAndWords.solution3(input));
        System.out.println(ReverseLettersAndWords.solution4(input));
    }

}
