package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
 */
public class MaximumLevelSumBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> levelList = new ArrayList();
        dfs(root, levelList, 0);

        int maxLevelSum = levelList.get(0);
        int index = 0;
        for (int i = 1; i < levelList.size(); i++) {
            if (maxLevelSum < levelList.get(i)) {
                maxLevelSum = levelList.get(i);
                index = i;
            }
        }
        return index + 1;
    }

    private void dfs(TreeNode root, List<Integer> levelList, int level) {
        if (root == null) {
            return;
        }

        if (level == levelList.size()) {
            levelList.add(root.val);
        } else {
            levelList.set(level, levelList.get(level) + root.val);
        }
        dfs(root.left, levelList, level + 1);

        dfs(root.right, levelList, level + 1);
    }
}
