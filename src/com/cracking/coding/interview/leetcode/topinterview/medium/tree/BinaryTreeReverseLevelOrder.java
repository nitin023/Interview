package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.*;

/**
 * Medium
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeReverseLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> responseList = getLevelOrderTraversal(root);
        Collections.reverse(responseList);
        return responseList;
    }

    private List<List<Integer>> getLevelOrderTraversal(TreeNode node) {
        List<List<Integer>> records = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelOrderList = new ArrayList<>();
            while (count > 0) {
                TreeNode currentNode = queue.peek();
                levelOrderList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                queue.remove();
                count--;
            }
            records.add(levelOrderList);
        }
        return records;
    }
}
