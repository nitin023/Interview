package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.*;

/**Medium
 * https://leetcode.com/problems/top-k-frequent-elements
 * Hashtable
 * O(nlogn) time and O(n) space complexity
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return gettopKFrequentElements(nums, k);
    }


    private int[] gettopKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int element : nums) {
            int frequency = freqMap.getOrDefault(element, 0) + 1;
            freqMap.put(element, frequency);
        }

        List<Map.Entry<Integer,Integer>> freqList = new ArrayList<>(freqMap.entrySet());

        freqList.sort((l1, l2) -> l2.getValue().compareTo(l1.getValue()));

        int[] topKFreqList = new int[k];
        int i = 0;
        while (i < k) {
            topKFreqList[i] = freqList.get(i).getKey();
            i++;
        }
        return topKFreqList;
    }
}
