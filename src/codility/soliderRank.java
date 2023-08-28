package codility;

import java.util.HashSet;
import java.util.Set;

/*
 * In the army, each soldier has an assigned rank. A soldier of rank X has to
 * report to (any) soldier of rank X+1. Many Soldiers can report to the same
 * superior. Write a function: that given an array ranks consisting ranks return
 * the number of soldiers who can report to some Superior. Examples:
 * 1) Given ranks = [3,4,3,0,2,2,3,0,0] should return 5
 * 2) Given Ranks = [4,2,0] should return 0
 * 3) Given Ranks = [4,4,3,3,1,0] your function should return 3
 */
public class soliderRank {

    // O(n) - time
    // O(n) - space

    public static int solution(int[] ranks) {
        int count = 0;
        Set<Integer> uniqueRanks = new HashSet<Integer>();

        for (int i = 0; i < ranks.length; i++) {
            uniqueRanks.add(ranks[i]);
        }

        for (int i = 0; i < ranks.length; i++) {
            int rank = ranks[i];
            if (uniqueRanks.contains(rank + 1))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ranks = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        System.out.println(soliderRank.solution(ranks));
        int[] ranks2 = {4, 2, 0};
        System.out.println(soliderRank.solution(ranks2));
        int[] ranks3 = {4, 4, 3, 3, 1, 0};
        System.out.println(soliderRank.solution(ranks3));
    }
}