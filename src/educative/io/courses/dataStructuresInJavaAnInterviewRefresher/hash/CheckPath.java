package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashMap;
import java.util.Map;

/*
Challenge 4: Trace the complete path of a journey

Given a HashMap with all the points, can you find the starting point
and print out the complete path from start to end? A solution is placed 
in the "solution" section to help you, but we would suggest you try to 
solve it on your own first.

author: francesco giordano
*/
public class CheckPath {

    public static String tracePath(Map<String, String> map) {

        // n -> c
        // b -> t
        // m -> n
        // t -> m
        // reverse 
        // c -> n
        // t -> b
        // n -> m
        // m -> t

        // time O(n)
        // space O(n)

        String result = "";
        String point = "";

        Map<String, String> reverseMap = new HashMap<String, String>();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        // find starting point
        for (Map.Entry<String, String> entry: map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                point = entry.getKey();
                break;
            }
        }

        while (map.containsKey(point)) {

            String dest = "";
            String source = "";

            dest = point;
            source = map.get(point);

            result += dest+"->"+source+", ";

            point = source;
        }

        return result;
    }

    public static void main(String args[]) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("NewYork", "Chicago");
        map.put("Boston", "Texas");
        map.put("Missouri", "NewYork");
        map.put("Texas", "Missouri");

        System.out.println(CheckPath.tracePath(map));
    }

}
