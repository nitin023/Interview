package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        List<Integer> preorderList = new ArrayList<>();

        getPreOrderTraversal(root, preorderList);

        flattenTree(root, preorderList, 1);

    }


    private void getPreOrderTraversal(TreeNode root, List<Integer> preorderList) {
        if (root == null) {
            return;
        }
        preorderList.add(root.val);
        getPreOrderTraversal(root.left, preorderList);
        getPreOrderTraversal(root.right, preorderList);
    }

    private void flattenTree(TreeNode root, List<Integer> preorderList, int index) {

        if (index >= preorderList.size()) {
            return;
        }
        root.left = null;
        root.right = new TreeNode(preorderList.get(index));
        flattenTree(root.right, preorderList, index + 1);
    }
}
