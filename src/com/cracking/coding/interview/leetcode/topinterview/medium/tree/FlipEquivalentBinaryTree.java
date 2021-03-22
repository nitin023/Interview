package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees
 * Medium
 */
public class FlipEquivalentBinaryTree {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return (root1.val == root2.val) &&
                (flipEquiv(root1.left, root2.left) || flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) || flipEquiv(root1.right, root2.left));
    }
}
