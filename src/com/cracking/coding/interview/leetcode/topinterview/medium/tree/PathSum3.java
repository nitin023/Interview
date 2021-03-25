package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSum3 {
    int count = 0;
    List<Integer> list = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        getPathSumCount(root, sum);
        return count;
    }

    private void getPathSumCount(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        getPathSumCount(root.left, sum);
        getPathSumCount(root.right, sum);

        int tempSum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            tempSum += list.get(i);
            if (tempSum == sum) {
                count++;
            }
        }
        list.remove(list.size() - 1);
    }
}
