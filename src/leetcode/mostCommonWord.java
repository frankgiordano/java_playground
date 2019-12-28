package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a paragraph and a list of banned words, return the most frequent
word that is not in the list of banned words.  It is guaranteed there
is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of 
punctuation.  Words in the paragraph are not case sensitive.  The answer 
is in lowercase.

author francesco giordano
*/
public class MostCommonWord {

    public static String solution(String paragraph, String[] banned) {

        // corner case
        if (paragraph == null || paragraph.isEmpty())
            return "";

        Map<String, Integer> words = new HashMap<String, Integer>();
        Set<String> bannedSet = new HashSet<String>();
        int size = paragraph.length();

        for (int i = 0; i < banned.length && i < 100; i++)
            bannedSet.add(banned[i]);

        int startWordIndex = 0;
        for (int i = 0; i < size && i < 1000; i++) {
            char c = paragraph.charAt(i);
            String word = "";

            // edge case end of string with no special character handle the last word
            if (i == size -1 && startWordIndex != 0) {
                word = paragraph.substring(startWordIndex, i+1);
                setWord(words, bannedSet, word);
            }

            if (c == ' ' || c == '?' || c == '!' || c == ';' || c == '.' || c == ',' || c == '\'')  { 
                word = paragraph.substring(startWordIndex, i);
                setWord(words, bannedSet, word);
                startWordIndex = i + 1;
            }
        }

        // edge case only one word in the input with no special character handle the first word
        if (startWordIndex == 0) {
            String word = paragraph.toLowerCase();
            setWord(words, bannedSet, word);
        }

        // return the most common word not in banned list
        int highestCount = 0;
        String highestCountedWord = "";
        
        for (Map.Entry<String, Integer> m: words.entrySet())
        {
                int count = (int) m.getValue();
                if (count > highestCount) {
                    highestCount = count;
                    highestCountedWord = (String) m.getKey();
                }
        }

        return highestCountedWord;
    }

    private static void setWord(Map<String, Integer> words, Set<String> bannedSet, String word) {
        word = word.toLowerCase();
        if (words.containsKey(word)) {
            int count = words.get(word);
            count += 1;
            words.put(word, count);
        } else {  // is newly seen put in first time with 1 count
            words.put(word, 1);
        }
    }

    public static void main(String[] args) {
        String[] banned = { "m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n" };
        System.out.println(MostCommonWord.solution("j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q, x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r. p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?", banned));
        String[] banned2 = { "hit" };
        System.out.println(MostCommonWord.solution("Bob hit a ball, the hit BALL flew far after it was hit.", banned2));
    }

}