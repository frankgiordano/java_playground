package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.stack;

public class checkCeleb {

    public static boolean knows(int[][] party, int a, int b) {
        return party[a][b] == 1 ? true: false;
    }

    public static int findCelebrity(int[][] party, int numPeople) {

        myStack stack = new myStack(numPeople);
        int celebrity = -1;

        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int a = stack.pop();
            
            if (stack.isEmpty()) {
                celebrity = a;
                break;
            }

            int b = stack.pop();

            if (knows(party, a,b))
                stack.push(b);
            else 
                stack.push(a);
        }

        for (int i = 0; i < numPeople; i++) {

            if ((i != celebrity) && (knows(party, celebrity, i) || !knows(party, i, celebrity))) 
              return -1; 
        }

        return celebrity;
    }

    public static void main(String[] args) {

        int MATRIX[][] = { { 0, 0, 1, 0 }, 
                            { 0, 0, 0, 0 }, 
                            { 0, 0, 1, 0 },  
                            { 0, 0, 1, 0 } }; 

        int n = 4; 
        int result = findCelebrity(MATRIX, n); 
        if (result == -1)  
        { 
            System.out.println("No Celebrity"); 
        }  
        else
            System.out.println("Celebrity ID " +  result); 
    }
}