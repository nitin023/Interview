package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructTreeFromInorderAndPreorder {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderDataIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderDataIndexMap.put(inorder[i], i);
        }
        return constructTreeFromInorderAndPreorder(preorder, inorder, inorderDataIndexMap, 0, inorder.length - 1);
    }

    private TreeNode constructTreeFromInorderAndPreorder(int[] preorder, int[] inorder, Map<Integer, Integer> inorderDataIndexMap, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (start == end) {
            return root;
        }

        int inorderIndex = inorderDataIndexMap.get(root.val);

        root.left = constructTreeFromInorderAndPreorder(preorder, inorder, inorderDataIndexMap, start, inorderIndex - 1);

        root.right = constructTreeFromInorderAndPreorder(preorder, inorder, inorderDataIndexMap, inorderIndex + 1, end);

        return root;
    }
}
