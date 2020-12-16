package playground;

/**
 * POC code snippet I used for a project to extract a parameter with its values in a parameter String list 
 * delimited by comma character.  
 */
public class ExtractStringWithValue {

    public static String getStringWithValue(String parameter, String content) {

        if (!parameter.contains("=")) {
            return "";
        }

        int index = content.indexOf(parameter);
        String subStr = content.substring(index);
        int lastIndex = subStr.length();
        if (subStr.indexOf(",") != -1)
          lastIndex = subStr.indexOf(",");

        return subStr.substring(0, lastIndex);    
    }

    public static void main(String[] args) {
        String result = ExtractStringWithValue.getStringWithValue("COMMUNICATION=", "COMMUNICATION=NONE, NEXT=POINT");
        System.out.println(result);
        result = ExtractStringWithValue.getStringWithValue("COMMUNICATION=", "COMMUNICATION=NONE");
        System.out.println(result);
    }

}
