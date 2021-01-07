package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        findTopKElement(new int[]{1, 1, 1, 2, 2, 3}, 3);
    }

    public static int[] topKFrequent(int[] numbs, int k) {
        if (numbs == null || numbs.length == 0) {
            return numbs;
        }
        return findTopKElement(numbs, k);
    }

    /**
     * Complexity : O(N*logK)
     *
     * @param numbs
     * @param k
     * @return
     */
    private static int[] findTopKElement(int[] numbs, int k) {

        Map<Integer, Integer> numberFreqMap = new HashMap();

        for (int item : numbs) {
            int currentFreq = numberFreqMap.getOrDefault(item, 0) + 1;
            numberFreqMap.put(item, currentFreq);
        }

        int[] response = new int[k];

        int i = 0;

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(numberFreqMap::get));

        for (int n : numberFreqMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {heap.poll();}
        }

        for (i = k - 1; i >= 0; --i) {
            response[i] = heap.poll();
        }

        return response;
    }

}
