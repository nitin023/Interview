package com.cracking.coding.interview.leetcode.topinterview.easy;

import java.util.PriorityQueue;

/**Easy
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 * Keep only K elements inside priority queue for stream processing
 */
public class KthLargestInStream {

    final int k;
    final PriorityQueue<Integer> pq;

    public KthLargestInStream(int k, int[] nums) {
        this.pq = new PriorityQueue(k);
        this.k = k;

        for (int item : nums) {
            add(item);
        }
    }

    public int add(int val) {

        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
