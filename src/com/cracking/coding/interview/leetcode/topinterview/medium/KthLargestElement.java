package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Medium
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 * O(N) best case / O(N^2) worst case running time + O(1) memory
 */
public class KthLargestElement {

    public int findKthLargest(int[] numList, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int item : numList) {
            queue.add(item);
        }

        int response = 0;
        while (k > 0 && !queue.isEmpty()) {
            response = queue.poll();
            k--;
        }
        return response;
    }
}
