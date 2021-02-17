package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/symmetric-tree/
 */
public class MirrorRefection {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorReflection(root, root);
    }

    private boolean isMirrorReflection(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }
        return (tree1.val == tree2.val) &&
                isMirrorReflection(tree1.left, tree2.right) && isMirrorReflection(tree1.right, tree2.left);
    }
}
