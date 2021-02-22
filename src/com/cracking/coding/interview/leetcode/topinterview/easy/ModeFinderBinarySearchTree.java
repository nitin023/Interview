package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/submissions/
 */
public class ModeFinderBinarySearchTree {
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList();
        modeFinder(root, list);
        int[] resultSet = new int[list.size()];
        for (int i = 0; i < resultSet.length; i++)
            resultSet[i] = list.get(i);
        return resultSet;
    }

    private void modeFinder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        modeFinder(root.left, list);
        //value of root
        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else
                count = 1;
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        modeFinder(root.right, list);
    }
}
