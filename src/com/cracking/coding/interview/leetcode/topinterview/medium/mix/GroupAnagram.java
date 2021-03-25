package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import java.util.*;

/**
 * Medium
 * https://leetcode.com/problems/group-anagrams
 * O(N*K*logK)
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null ||  strs.length == 0){
            return new ArrayList();
        }

        Map<String ,List<String>> groupAnagramListMap = new HashMap();

        for(String item : strs){

            char[] itemArray = item.toCharArray();
            Arrays.sort(itemArray);
            StringBuilder sb = new StringBuilder(itemArray.length);
            for(char a : itemArray){
                sb.append(a);
            }
            String mapSortedKey = sb.toString();
            groupAnagramListMap.putIfAbsent(mapSortedKey , new ArrayList());
            groupAnagramListMap.get(mapSortedKey).add(item);
        }

        List<List<String>> responseList = new ArrayList();

        for(Map.Entry<String , List<String>> mk : groupAnagramListMap.entrySet()){
            responseList.add(mk.getValue());
        }

        return responseList;
    }
}
