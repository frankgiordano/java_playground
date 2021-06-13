package JavaCodingProblems.StringNumbersMath;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1. Counting duplicate characters
 */
public class CountDuplicateCharacters {

    public static Map<Character, Integer> solution1(String str) {

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                int count = result.get(c);
                result.put(c, ++count);
            }
        }

        return result;
    }

    public static Map<Character, Integer> solution2(String str) {

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            // java 8 style with compute
            result.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public static Map<Character, Long> solution3(String str) {

        Map<Character, Long> result = new HashMap<>();

        // java 8 style with stream..
        result = str.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        return result;
    }


    public static void main(String[] args) {

        String input = "loveleetcode";

        Map<Character, Integer> result = CountDuplicateCharacters.solution1(input);
        for (Map.Entry<Character, Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
        result = CountDuplicateCharacters.solution2(input);
        for (Map.Entry<Character, Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
        Map<Character, Long> results = CountDuplicateCharacters.solution3(input);
        for (Map.Entry<Character, Long> entry: results.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    
}
