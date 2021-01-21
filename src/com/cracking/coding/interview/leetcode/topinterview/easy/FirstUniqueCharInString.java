package com.cracking.coding.interview.leetcode.topinterview.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * https://leetcode.com/problems/first-unique-character-in-a-string
 */
public class FirstUniqueCharInString {
    public int firstUniqueChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        Map<Character, List<Integer>> charFreqMap = new LinkedHashMap();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            charFreqMap.putIfAbsent(item, new ArrayList<>());
            charFreqMap.get(item).add(i);
        }

        for (Map.Entry<Character, List<Integer>> entrySet : charFreqMap.entrySet()) {
            if (entrySet.getValue().size() == 1) {
                return entrySet.getValue().get(0);
            }
        }
        return -1;
    }
}
