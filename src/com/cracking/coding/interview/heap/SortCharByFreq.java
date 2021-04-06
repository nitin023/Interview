package com.cracking.coding.interview.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharByFreq {

    public String frequencySort(String s) {

        if(s == null || s.length() < 2){
            return s;
        }

        Map<Character,Integer> freqCharMap = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char entry = s.charAt(i);

            int freq = freqCharMap.getOrDefault(entry, 0);
            freqCharMap.put(entry,freq+1);
        }

        Comparator<QueueEntry> comparator = Comparator.comparingInt(a -> -a.frequency);

        PriorityQueue<QueueEntry> queue = new PriorityQueue<>(comparator);


        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character,Integer> entry : freqCharMap.entrySet()){
            queue.add(new QueueEntry(entry.getKey(),entry.getValue()));
        }

        while(!queue.isEmpty()){
            QueueEntry entry = queue.poll();
            int freq = entry.frequency;
            char value = entry.item;

            while(freq > 0){
                sb.append(value);
                freq--;
            }
        }

        return sb.toString();
    }
}

class QueueEntry{
    char item;
    int frequency;

    public QueueEntry(char item , int frequency){
        this.item = item;
        this.frequency = frequency;
    }
}
