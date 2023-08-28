package leetcode;

import java.util.*;

// Given a non-empty array of integers, return the k most frequent elements.

public class TopKFrequentElements {

    static class ValueStats {
        private final Integer key;
        private final Integer count;

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

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        Queue<ValueStats> queue = new PriorityQueue<>(Comparator.comparing(ValueStats::getCount).reversed());

        for (int num : nums) {
            if (frequency.containsKey(num)) {
                int count = frequency.get(num);
                frequency.put(num, ++count);
            } else {
                frequency.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            queue.add(new ValueStats(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {

        // this is O(n log k) slightly better

        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(frequency::get));

        for (int num : nums) {
            if (frequency.containsKey(num)) {
                int count = frequency.get(num);
                frequency.put(num, ++count);
            } else {
                frequency.put(num, 1);
            }
        }

        for (int n : frequency.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (k-- > 0) {
            result.add(queue.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements instance = new TopKFrequentElements();
        int[] input = {1, 1, 1, 2, 2, 3};
        List<Integer> result = instance.topKFrequent1(input, 2);
        for (Integer r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        int[] input2 = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        result = instance.topKFrequent2(input2, 2);
        for (Integer r : result) {
            System.out.print(r + " ");
        }
    }

}