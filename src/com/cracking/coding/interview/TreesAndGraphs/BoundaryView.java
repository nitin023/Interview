package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://www.lintcode.com/problem/boundary-of-binary-tree/description
 */
public class BoundaryView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        boundaryOfBinaryTree(root);
    }

    private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> boundaryTraversal = new ArrayList<>();
        boundaryTraversal.add(root.val);
        collectLeftBoundary(boundaryTraversal, root.left);
        collectLeafNodes(boundaryTraversal,root);
        collectRightBoundary(boundaryTraversal, root.right);
        return boundaryTraversal;
    }

    private static void collectLeftBoundary(List<Integer> boundaryTraversal, TreeNode root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        boundaryTraversal.add(root.val);
        collectLeftBoundary(boundaryTraversal, root.left != null ? root.left : root.right);
    }

    private static void collectRightBoundary(List<Integer> boundaryTraversal, TreeNode root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        collectRightBoundary(boundaryTraversal, root.right != null ? root.right : root.left);
        boundaryTraversal.add(root.val);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void collectLeafNodes(List<Integer> boundaryTraversal, TreeNode root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            boundaryTraversal.add(root.val);
        } else {
            collectLeafNodes(boundaryTraversal, root.left);
            collectLeafNodes(boundaryTraversal, root.right);
        }
    }
}
