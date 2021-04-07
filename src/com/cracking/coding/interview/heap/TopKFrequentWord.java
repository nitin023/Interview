package com.cracking.coding.interview.heap;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return null;
        }

        Map<String, Integer> wordFreqMap = new HashMap<>();

        for (String str : words) {
            int freq = wordFreqMap.getOrDefault(str, 0) + 1;
            wordFreqMap.put(str, freq);
        }

        Comparator<ElemFrequency> comparator = (o1, o2) -> {
            if (o1.frequency == o2.frequency) {
                return o1.code.compareTo(o2.code);
            }
            return Integer.compare(o2.frequency, o1.frequency);
        };

        PriorityQueue<ElemFrequency> queue = new PriorityQueue<>(comparator);

        for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()) {
            queue.add(new ElemFrequency(entry.getKey(), entry.getValue()));
        }

        List<String> responseList = new ArrayList<>(k);

        while (k > 0 && !queue.isEmpty()) {
            ElemFrequency elemFrequency = queue.poll();
            responseList.add(elemFrequency.code);
            k--;
        }
        return responseList;
    }
}

class ElemFrequency {
    String code;
    int frequency;

    public ElemFrequency(String code, int frequency) {
        this.code = code;
        this.frequency = frequency;
    }
}
