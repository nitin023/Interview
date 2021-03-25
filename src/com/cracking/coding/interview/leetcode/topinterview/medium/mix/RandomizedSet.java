package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import java.util.*;

/**
 * Medium
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 */
public class RandomizedSet {
    Map<Integer, Integer> valueIndexMap;
    List<Integer> itemsList;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        valueIndexMap = new HashMap();
        itemsList = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int index = valueIndexMap.getOrDefault(val, -1);
        if (index > -1) {
            return false;
        }
        itemsList.add(val);
        valueIndexMap.put(val, itemsList.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = valueIndexMap.getOrDefault(val, -1);
        if (index == -1) {
            return false;
        }
        Collections.swap(itemsList, index, itemsList.size() - 1);
        int swappedWith = itemsList.get(index);
        valueIndexMap.put(swappedWith, index);
        valueIndexMap.remove(val);
        itemsList.remove(itemsList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int max = itemsList.size();
        int min = 0;
        int ind = (int) (Math.random() * (max - min) + min);
        return itemsList.get(ind);
    }
}
