package codility;

public class daysOfTheWeek {
    public static String solution(String S, int K) {
        
        String[] daysOfTheWeek = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        int day_position = -1;
        
        switch (S) {
            case "Mon": day_position = 0;
                        break;
            case "Tus": day_position = 1;
                        break;
            case "Wed": day_position = 2;
                        break;
            case "Thu": day_position = 3;
                        break;
            case "Fri": day_position = 4;
                        break;
            case "Sat": day_position = 5;
                        break;
            case "Sun": day_position = 6;
                        break;
            default:    day_position = -1;
                        break;
        }
        
        if (day_position == -1)
            return null;
        
        String pointer = daysOfTheWeek[day_position++];
        if (day_position == 7)
        day_position = 0;

        for (int i = 0; i < K; i++) {
            pointer = daysOfTheWeek[day_position++];
            if (day_position == 7)
                day_position = 0;
        }
        
        return pointer;
    }

    public static void main(String[] args) {
        System.out.println(daysOfTheWeek.solution("Wed", 2));
        System.out.println(daysOfTheWeek.solution("Sat", 23));
    }
}