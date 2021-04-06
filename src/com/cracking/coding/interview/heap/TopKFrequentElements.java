package com.cracking.coding.interview.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

        for (int item : nums) {
            int frequency = numberFrequencyMap.getOrDefault(item, 0);
            numberFrequencyMap.put(item, frequency + 1);
        }

        Comparator<ElementWrapper> comparator = Comparator.comparingInt(a -> -a.freq);

        PriorityQueue<ElementWrapper> queue = new PriorityQueue<>(comparator);

        for (Map.Entry<Integer, Integer> mk : numberFrequencyMap.entrySet()) {
            queue.add(new ElementWrapper(mk.getKey(), mk.getValue()));
        }

        int i = 0;
        int[] response = new int[k];

        while (k > 0) {
            k--;
            response[i++] = queue.poll().elem;
        }
        return response;

    }


    static class ElementWrapper {
        int elem;
        int freq;

        public ElementWrapper(int elem, int freq) {
            this.elem = elem;
            this.freq = freq;
        }
    }
}
