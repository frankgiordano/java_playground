package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Given a non-empty array of integers, return the k most frequent elements.

class topKFrequentElements {
    
    class ValueStats {
        private Integer key;
        private Integer count;
        
        public ValueStats(Integer key, Integer count) {
            this.key = key;
            this.count = count;
        }
        
        public Integer getKey() {
            return this.key;
        }
        
        public Integer getCount() {
            return this.count;
        }
    }
    
    public List<Integer> topKFrequent1(int[] nums, int k) {

        // this is O(nlogn) it can be done faster
        
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        Queue<ValueStats> queue = new PriorityQueue<ValueStats>
                                    (Comparator.comparing(ValueStats::getCount).reversed());
        
        for (int num: nums) {
            if (frequency.containsKey(num)) {
                int count = frequency.get(num);
                frequency.put(num, ++count);
            } else {
                frequency.put(num, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
            queue.add(new ValueStats(entry.getKey(), entry.getValue()));
        }
        
        for (int i = 0; i < k; i++)
         result.add(queue.poll().getKey());
        
        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {

        // this is O(nlogk)  slightly better
        
        List<Integer> result = new LinkedList();
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new PriorityQueue<Integer>
                                    ((n1, n2) -> frequency.get(n1) - frequency.get(n2));
        
        for (int num: nums) {
            if (frequency.containsKey(num)) {
                int count = frequency.get(num);
                frequency.put(num, ++count);
            } else {
                frequency.put(num, 1);
            }
        }
        
        for (int n : frequency.keySet()) {
            queue.add(n);
            if (queue.size() > k)
                queue.poll();
        }
        
        while (k-- > 0)
         result.add(queue.poll());
        Collections.reverse(result);
        
        return result;
    }

    public static void main(String[] args) {
        topKFrequentElements instance = new topKFrequentElements();
        int[] input = {1,1,1,2,2,3};
        List<Integer> result = instance.topKFrequent1(input, 2);
        for (Integer r: result)
            System.out.print(r + " ");
        System.out.println();
        result = instance.topKFrequent2(input, 2);
        for (Integer r: result)
                System.out.print(r + " ");
    }

}