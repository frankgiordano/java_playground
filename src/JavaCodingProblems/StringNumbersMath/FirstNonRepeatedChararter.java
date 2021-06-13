
package JavaCodingProblems.StringNumbersMath;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2. Finding the first non-repeated character
 */
public class FirstNonRepeatedChararter {

  private static final int EXTENDED_ASCII_CODES = 256;

  public static char solution1(String str) {

    int[] flags = new int[EXTENDED_ASCII_CODES];

    // loop through all ascii values and set them to -1
    for (int i = 0; i < flags.length; i++) {
      flags[i] = -1;
    }

    // loop through all acsii values and for each character
    // seen for the first time set its array value with the
    // index value of where it is located in the input String
    // if the character has been seen before it is != -1
    // then set it to -2 this is the second time seen so 
    // lets ignore it going forward
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (flags[ch] == -1) {
        flags[ch] = i;
      } else {
        flags[ch] = -2;
      }
    }

    int position = Integer.MAX_VALUE;

    // loop through all ascii characters via the array
    // and check for those array values that are bigger than zero
    // meaning it was seen once and keep track of the lowest
    // array index value
    for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
      if (flags[i] >= 0) {
        position = Math.min(position, flags[i]);
      }
    }

    // send lowest array index value
    return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
  }

  public static char solution2(String str) {

    // this example uses HashMap so we dont have to keep track of
    // all ascii instance.. the usage of LinkedHashMap allows us to
    // track the first instance added to the Hash that has a count of one
    // with the Linked structure the first instance of count one will be random
    Map<Character, Integer> chars = new LinkedHashMap<>();

    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      if (chars.containsKey(c)) {
        int count = chars.get(c);
        chars.put(c, ++count);
      } else {
        chars.put(c, 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
      if (entry.getValue() == 1)
        return entry.getKey();
    }

    return ' ';
  }

  public static char solution3(String str) {

    // same as above but using java 8 technique. 
    Map<Character, Integer> chars = new LinkedHashMap<>();

    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);

      // one line of code replaces 6 lines! 
      // (v == null) ? 1 : ++v translate to:
      // if (!chars.containsKey(c)) chars.out(c, 1) else chars.put(c, ++chars.get(c));
      chars.compute(c, (k, v) -> (v == null) ? 1 : ++v);
      // if (chars.containsKey(c)) {
      //   int count = chars.get(c);
      //   chars.put(c, ++count);
      // } else {
      //   chars.put(c, 1);
      // }
    }

    for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
      if (entry.getValue() == 1)
        return entry.getKey();
    }

    return ' ';
  }


  public static void main(String[] args) {
    String input = "loveleetcode";
    System.out.println(FirstNonRepeatedChararter.solution1(input));
    System.out.println(FirstNonRepeatedChararter.solution2(input));
    System.out.println(FirstNonRepeatedChararter.solution3(input));
  }

}