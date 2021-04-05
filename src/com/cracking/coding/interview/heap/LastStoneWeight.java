package com.cracking.coding.interview.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /**
     * https://leetcode.com/problems/last-stone-weight/
     */
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int item : stones) {
            queue.add(item);
        }

        while (queue.size() != 1) {
            int x = queue.poll();
            int y = queue.poll();

            if (x != y) {
                queue.add(x - y);
            }
            if (queue.isEmpty()) {
                break;
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
