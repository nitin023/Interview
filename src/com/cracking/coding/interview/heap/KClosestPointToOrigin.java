package com.cracking.coding.interview.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Medium
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointToOrigin {
    public  int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int[][]{};
        }
        Comparator<int []> pointCompare = (a,b) -> b[2] - a[2];
        PriorityQueue<int[]> closestK = new PriorityQueue<>(k, pointCompare);
        int[][] ans = new int[k][2];
        for (int[] point : points) {
            closestK.add(new int[]{point[0], point[1], point[0] * point[0] + point[1] * point[1]});
            if (closestK.size() > k) {
                closestK.poll();
            }
        }
        int[][] response = closestK.toArray(new int[0][0]);
        for (int i = 0; i < k; i++){
            ans[i][0] = response[i][0];
            ans[i][1] = response[i][1];
        }
        return ans;
    }
}
