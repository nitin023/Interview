package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    /**
     * This solution works by finding i < j pairs
     * and eval those pairs for some k
     * such that i < j < k if such cond exists we return true
     * else we return false
     * it solves problem in N*N complexity
     * @param numbs collection on which above algo is eval
     * @return true or false
     */
    public boolean increasingTripletInNSqrTime(int[] numbs) {
        if (numbs == null || numbs.length < 3) {
            return false;
        }

        int length = numbs.length;

        ArrayList<ArrayList<Integer>> pairList = new ArrayList<>(length * length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbs[i] < numbs[j]) {
                    pairList.add(new ArrayList<>());
                    int pairListLen = pairList.size() - 1;
                    pairList.get(pairListLen).add(i);
                    pairList.get(pairListLen).add(j);
                }
            }
        }

        for (List<Integer> item : pairList) {
            int j = item.get(1);
            int num = numbs[j];

            for (int k = j + 1; k < length; k++) {
                if (num < numbs[k]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This works on simple approach to find some index i , j and k
     * It first consider i val as INT_MAX and j val also as INT_MAX
     * It traverse list and check if some i val < INT_MAX
     * if some thing is found it check for j val < INT_MAX too
     * and for k it just check if some k > j value
     * exists
     * Complexity : N
     * @param numbs numbs collection on which above algo is eval
     * @return true or false
     */
    public boolean increasingTripletInLinearTime(int[] numbs) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int item : numbs) {
            if (item <= min) {
                min = item;
            } else if (item < secondMin) {
                secondMin = item;
            } else if (item > secondMin) {
                return true;
            }
        }
        return false;
    }
}
