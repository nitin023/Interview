package com.cracking.coding.interview.leetcode.topinterview.medium;

/**
 * O(N2)
 * Dynamic programming
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Approach of solving -
 * Initialise longestIncSubSequence array with 1 value default
 * Start iterating an array i index compare it with all the j index for all j < i
 * Among all indexes find the maximum index of longestIncSubSequence
 */
public class LongestIncreasingSubSequence {

    private int getLongestIncreasingSubSequence(int[] numbsList) {
        if (numbsList == null || numbsList.length == 0) {
            return 0;
        }

        int arrayLength = numbsList.length;

        int[] longestIncSubSequence = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            longestIncSubSequence[i] = 1;
        }

        for (int i = 1; i < arrayLength; i++) {
            for (int j = 0; j < i; j++) {
                if (numbsList[i] > numbsList[j]) {
                    longestIncSubSequence[i] = Math.max(longestIncSubSequence[i], longestIncSubSequence[j] + 1);
                }
            }
        }

        int maxNumList = 0;
        for (int i = 0; i < arrayLength; i++) {
            maxNumList = Math.max(maxNumList, longestIncSubSequence[i]);
        }
        return maxNumList;
    }
}
