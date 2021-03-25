package com.cracking.coding.interview.leetcode.topinterview.medium.mix;


import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters
 * Based on divide and conquer
 * N2
 */
public class LongestSubstringKRepeatingChar {

    public int longestSubstring(String s, int k) {
        int length = s.length();

        if(length == 0 || k > length) return 0;

        if(k < 2) return length;

        Map<Character,Integer> characterFreqMap = new HashMap<>();

        for(char c :s.toCharArray()){
            characterFreqMap.put(c,characterFreqMap.getOrDefault(c,0)+1);
        }

        int l = 0;
        while (l < length && characterFreqMap.get(s.charAt(l)) >= k) l++;

        if(l>=length-1) return l;

        int ls1 = longestSubstring(s.substring(0,l),k);

        while (l < length && characterFreqMap.get(s.charAt(l)) < k) l++;

        int ls2 = l < length ?  longestSubstring(s.substring(l),k) : 0;

        return Math.max(ls1 , ls2);
    }

}
