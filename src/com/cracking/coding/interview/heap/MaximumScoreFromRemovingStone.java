package com.cracking.coding.interview.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-stones/
 */
public class MaximumScoreFromRemovingStone {
    public int maximumScore(int a, int b, int c) {

        int maximumPossibleScore = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        pQueue.add(a);

        pQueue.add(b);

        pQueue.add(c);

        while (!pQueue.isEmpty()) {

            int elem1 = pQueue.poll() - 1;

            if (pQueue.isEmpty()) {
                break;
            }
            int elem2 = pQueue.poll() - 1;

            if (elem1 > 0) {
                pQueue.add(elem1);
            }

            if (elem2 > 0) {
                pQueue.add(elem2);
            }

            maximumPossibleScore++;
        }

        return maximumPossibleScore;
    }
}
