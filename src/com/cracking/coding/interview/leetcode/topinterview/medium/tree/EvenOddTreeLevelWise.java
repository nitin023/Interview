package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/even-odd-tree/
 */
public class EvenOddTreeLevelWise {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        boolean even = true;

        while (q.size() > 0) {
            int size = q.size();

            int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (size-- > 0) {
                root = q.poll();
                if (even && (root.val % 2 == 0 || root.val <= prevVal)) return false;

                if (!even && (root.val % 2 == 1 || root.val >= prevVal)) return false;

                prevVal = root.val;

                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            even = !even;
        }

        return true;
    }
}
