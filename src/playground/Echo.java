package playground;

/**
 * This is a POC sample I created to mimic a portion of the unix echo command.
 * It uses recursion to transverse a string and its starting and ending quotes to
 * concatenate output string.
 *
 * @author Frank Giordano
 */
public class Echo {

    public enum QuoteType {

        DoubleQuote("\""),
        SingleQuote("'");

        private final String value;

        QuoteType(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static String extractQuotedData(String str, QuoteType quoteType) {
        char quoteChar;
        if ("\"".equals(quoteType.value)) {
            quoteChar = '"';
        } else {
            quoteChar = '\'';
        }
        long numberOfQuotes = str.chars().filter(ch -> ch == quoteChar).count();
        if (numberOfQuotes == 0) {
            return str;
        }

        int index = str.indexOf(quoteChar);
        String result = str.substring(0, index);
        result = result + str.substring(index + 1, str.length() - 1);

        return extractQuotedData(result, quoteType);
    }

    public static boolean validateEvenQuotes(String str) {
        long numberOfDoubleQuotes = str.chars().filter(ch -> ch == '\"').count();
        long numberOfSingleQuotes = str.chars().filter(ch -> ch == '\'').count();

        return (numberOfDoubleQuotes % 2 == 0) && (numberOfSingleQuotes % 2 == 0);
    }

    public static void main(String[] args) {

        String input1 = "frank'fran frank'\"\"\"\"";
        System.out.println(validateEvenQuotes(input1));
        String result1 = extractQuotedData(input1, QuoteType.SingleQuote);
        result1 = extractQuotedData(result1, QuoteType.DoubleQuote);
        System.out.println(result1);

        String input2 = "frank'fran\"\" frank'\"\"\"\"";
        System.out.println(validateEvenQuotes(input2));
        String result2 = extractQuotedData(input2, QuoteType.SingleQuote);
        result2 = extractQuotedData(result2, QuoteType.DoubleQuote);
        System.out.println(result2);

        String input3 = "frank\"frank\"hello\"\"";
        System.out.println(validateEvenQuotes(input3));
        System.out.println(extractQuotedData(input3, QuoteType.DoubleQuote));
        String input4 = "frank\"fran frank\"\"\"\"\"";
        System.out.println(validateEvenQuotes(input4));
        System.out.println(extractQuotedData(input4, QuoteType.DoubleQuote));

        String input5 = "frank\"fran frank\"\"\"\"\"\"";
        System.out.println(validateEvenQuotes(input5));
    }

}
