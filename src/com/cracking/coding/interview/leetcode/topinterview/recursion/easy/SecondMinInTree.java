package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Easy
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinInTree {
    private Set<Integer> set = new HashSet();

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        dfs(root);
        if (set.size() == 1) {
            return -1;
        }
        List<Integer> tempList = new ArrayList(set);

        int firstMin = tempList.get(0);
        int secondMin = tempList.get(1);

        if (tempList.size() == 2) {
            return Math.max(firstMin, secondMin);
        }

        for (int i = 2; i < tempList.size(); i++) {
            int item = tempList.get(i);
            if (item < firstMin) {
                secondMin = Math.max(firstMin, secondMin);
                firstMin = item;
            }
        }
        return secondMin;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        set.add(root.val);
        dfs(root.right);
    }
}
