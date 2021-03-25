package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

/**
 * Medium
 * https://leetcode.com/problems/shuffle-an-array/
 * Complexity O(N) time and space complexity
 * Used Fisher-Yates algorithm for shuffling array
 */
public class ShuffleArray {
    private final int[] numbs;
    private int[] clonedArray;

    public ShuffleArray(int[] numbs) {
        this.numbs = numbs;
        this.clonedArray = numbs.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return numbs;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        if (numbs == null) return null;


        for (int i = 0; i < clonedArray.length; i++) {
            int rand = (int) (Math.random() * (numbs.length - i)) + i;
            swap(clonedArray, i, rand);
        }

        return clonedArray;
    }

    public void swap(int[] numbs, int i, int j) {
        int temp = numbs[i];
        numbs[i] = numbs[j];
        numbs[j] = temp;
    }
}
