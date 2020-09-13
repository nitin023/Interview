package com.cracking.coding.interview.StringAndArrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * https://leetcode.com/problems/valid-anagram/
 */
public class StringIsPermutationOFAnother {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap();
        int i;
        char item;

        for (i = 0; i < s.length(); i++) {
            item = s.charAt(i);
            map.putIfAbsent(item, 0);
            map.put(item, map.get(item) + 1);
        }

        for (i = 0; i < t.length(); i++) {
            item = t.charAt(i);
            if (!map.containsKey(item)) {
                return false;
            }
            map.put(item, map.get(item) - 1);
        }
        for (Map.Entry<Character, Integer> mk : map.entrySet()) {
            if (mk.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramFastest(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        char itemS, itemK;
        for (int i = 0; i < s.length(); i++) {
            itemS = s.charAt(i);
            itemK = t.charAt(i);

            counter[itemS - 'a']++;
            counter[itemK - 'a']--;
        }

        for (int item : counter) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }
}
