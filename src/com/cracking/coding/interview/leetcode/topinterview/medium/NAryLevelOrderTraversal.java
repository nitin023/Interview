package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.NAryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal
 */
public class NAryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NAryTreePostorderTraversal.Node root) {
        if (root == null) {
            return new ArrayList();
        }
        return getLevelOrderTraversal(root);
    }

    private List<List<Integer>> getLevelOrderTraversal(NAryTreePostorderTraversal.Node node) {
        List<List<Integer>> records = new ArrayList();
        Queue<NAryTreePostorderTraversal.Node> queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelOrderList = new ArrayList<>();
            while (count > 0) {
                NAryTreePostorderTraversal.Node currentNode = queue.peek();
                levelOrderList.add(currentNode.val);
                queue.addAll(currentNode.children);
                queue.remove();
                count--;
            }
            records.add(levelOrderList);
        }
        return records;
    }
}
