package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Medium
 * https://leetcode.com/problems/subsets
 * O(N*2^N)
 */
public class SubSets {

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
        System.out.println(1);
    }

    public static List<List<Integer>> subsets(int[] numbs) {

        if (numbs == null || numbs.length == 0) {
            return new ArrayList();
        }
        return generateSubSets(numbs);
    }


    private static List<List<Integer>> generateSubSets(int[] numbs) {
        long power_set_size = (long) Math.pow(2, numbs.length);

        Set<List<Integer>> _responseSet = new HashSet();

        int counter, j;

        int set_size = numbs.length;

        for (counter = 0; counter < power_set_size; counter++) {
            List<Integer> subsetList = new ArrayList();
            for (j = 0; j < set_size; j++) {
                if ((counter & (1 << j)) > 0) {
                    subsetList.add(numbs[j]);
                }
            }
            _responseSet.add(subsetList);
        }

        List<List<Integer>> generatedSubsetLists = new ArrayList(_responseSet.size());
        for (List<Integer> entry : _responseSet) {
            generatedSubsetLists.add(entry);
        }
        return generatedSubsetLists;
    }
}
